library(ISLR)
library(leaps)
head(College)

#omit na in variable college
college<-na.omit(College)
dim(college)
#split data
set.seed(123)
size<-floor(0.65*nrow(college))
train_idx = sample(1:dim(college)[1], size)
train<-college[train_idx,]
test<-college[-train_idx,]


###
#2#
###

#Apps.lm<-lm(Apps~Private+Accept+Enroll+Top10perc+Top25perc+F.Undergrad+P.Undergrad+Outstate+Room.Board+Books+Personal+PhD+Terminal+S.F.Ratio+perc.alumni+Expend+Grad.Rate ,data=college)
Apps.lm<-lm(Apps~., data=train)
summary(Apps.lm)
#plot(Apps.lm)
#abline(Apps.lm)
appsPredict<-predict(Apps.lm, test)
#test error
mean((appsPredict - test$Apps)^2)


###
#3#
###
# Cross validation to pick best lambda
x<-model.matrix(Apps~.,college)
y<-college$Apps
library(glmnet)
grid<-10^seq(10,-2,length=100)
head(x)

ridge.mod<-glmnet(x[,-1],y,alpha=0,lambda=grid)
dim(coef(ridge.mod))
ridge.mod$lambda[50]
round(coef(ridge.mod)[,50],3)
ridge.mod$lambda[60]
round(coef(ridge.mod)[,60],3)
sqrt(sum(coef(ridge.mod)[-1,60]^2))
round(predict(ridge.mod,s=50,type="coef")[1:18,],3)

# Let's select lambda using a training set and cross-validation
set.seed(1)
train<-sample(1:nrow(x),nrow(x)/2)
test<-(-train)
y.test<-y[test]
ridge.mod<-glmnet(x[train,-1],y[train],alpha=0,lambda=grid,thresh=1e-12)
# Let's look at lamba=4
ridge.pred<-predict(ridge.mod,s=4,newx=x[test,-1])
mean((ridge.pred-y.test)^2)
# How does this compare with just using the mean to predict y?
mean((mean(y[train])-y.test)^2)
# How about the extremes?
ridge.pred<-predict(ridge.mod,s=1e10,newx=x[test,-1])
mean((ridge.pred-y.test)^2)
ridge.pred<-predict(ridge.mod,s=0,newx=x[test,-1],exact=T)
mean((ridge.pred-y.test)^2)
lm(y~x,subset=train)
predict(ridge.mod,s=0,exact=T,type="coef")[1:20.]

# Cross validation to pick best lambda
set.seed(1)
cv.out<-cv.glmnet(x[train,],y[train],alpha=0)
plot(cv.out)
bestlam<-cv.out$lambda.min
bestlam
log(bestlam)
ridge.pred<-predict(ridge.mod,s=bestlam,newx=x[test,-1])
mean((ridge.pred-y.test)^2)
out<-glmnet(x[,-1],y,alpha=0)
round(predict(out,type="coef",s=bestlam)[1:18,],4)


###
#4#
###
# Lasso
lasso.mod<-glmnet(x[train,],y[train],alpha=1,lambda=grid)
plot(lasso.mod,lwd=2)
set.seed(1)
cv.out<-cv.glmnet(x[train,],y[train],alpha=1)
plot(cv.out)
bestlam<-cv.out$lambda.min
bestlam
log(bestlam)
lasso.pred<-predict(lasso.mod,s=bestlam,newx=x[test,])
mean((lasso.pred-y.test)^2)
out<-glmnet(x[,-1],y,alpha=1,lambda=grid)
lasso.coef<-predict(out,type="coef",s=bestlam)[1:18,]
lasso.coef
lasso.coef[lasso.coef!=0]

###
#5#
###
# PCR
library(pls)
set.seed(2)
pcr.fit<-pcr(Accept~.,data=college,scale=T,validation="CV")
summary(pcr.fit)
validationplot(pcr.fit,val.type="MSEP")
set.seed(1)
pcr.fit<-pcr(Accept~.,data=college,subset=train,scale=T,validation="CV")
validationplot(pcr.fit,val.type="MSEP")
pcr.pred<-predict(pcr.fit,x[test,-1],ncomp=7)
mean((pcr.pred-y.test)^2)
pcr.fit<-pcr(y~x[,-1],scale=T,ncomp=7)
summary(pcr.fit)

###
#6#
###
# Partial Least Squares
set.seed(1)
pls.fit<-plsr(Accept~.,data=college,subset=train,scale=T,validation="CV")
summary(pls.fit)
validationplot(pls.fit,val.type="MSEP")
pls.pred<-predict(pls.fit,x[test,-1],ncomp=2)
mean((pls.pred-y.test)^2)
pls.fit<-plsr(Accept~.,data=college,scale=T,ncomp=2)
summary(pls.fit)
