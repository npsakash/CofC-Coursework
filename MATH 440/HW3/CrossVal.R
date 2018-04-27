# Model Selection with Hitter Data

library(ISLR)
head(Hitters)
dim(Hitters)
sum(is.na(Hitters$Salary))
hitters<-na.omit(Hitters)
dim(hitters)
sum(is.na(hitters))

# Using AIC, Cp, BIC on Full Data Set with Best, Forward, Backward
library(leaps)
regfit.full<-regsubsets(Salary~.,data=hitters)
summary(regfit.full)

regfit.full<-regsubsets(Salary~.,data=hitters,nvmax=19)

reg.summary<-summary(regfit.full)
reg.summary
names(reg.summary)
reg.summary$rsq
par(mfrow=c(2,2))
plot(reg.summary$rss,xlab="# Vars",ylab="RSS",type="l")
plot(reg.summary$adjr2,xlab="# Vars",ylab="Adj RSq",type="l")
which.max(reg.summary$adjr2)
points(11,reg.summary$adjr2[11],col="red",cex=2,pch=20)
plot(reg.summary$cp,xlab="# Vars",ylab="Cp",type="l")
which.min(reg.summary$cp)
points(10,reg.summary$cp[10],col="red",cex=2,pch=20)
which.min(reg.summary$bic)
plot(reg.summary$bic,xlab="# Vars",ylab="BIC",type="l")
points(6,reg.summary$bic[6],col="red",cex=2,pch=20)
plot(regfit.full,scale="r2")
plot(regfit.full,scale="adjr2")
plot(regfit.full,scale="Cp")
plot(regfit.full,scale="bic")
# BIC chooses 6 variable model.
coef(regfit.full,6)

# Forward and Backward Stepwise
regfit.fwd<-regsubsets(Salary~.,data=hitters,nvmax=19,method="forward")
# Note how models are now nested.
summary(regfit.fwd)
regfit.bwd<-regsubsets(Salary~.,data=hitters,nvmax=19,method="backward")
summary(regfit.bwd)

# Methods agree through 6 variables, but differ at 7.
coef(regfit.full,7)
coef(regfit.fwd,7)
coef(regfit.bwd,7)

# Using a test set to choose models
set.seed(1)
train<-sample(c(TRUE,FALSE),nrow(hitters),rep=T)
test<-(!train)
regfit.best<-regsubsets(Salary~.,data=hitters[train,],nvmax=19)
test.mat<-model.matrix(Salary~.,data=hitters[test,])
val.errors<-rep(NA,19)
for(i in 1:19){
  coefi<-coef(regfit.best,id=i)
  pred<-test.mat[,names(coefi)]%*%coefi
  val.errors[i]<-mean((hitters$Salary[test]-pred)^2)
}
val.errors
which.min(val.errors)
coef(regfit.best,10)
# To get final model, choose 10 variables using full data set.
regfit.best<-regsubsets(Salary~.,data=hitters,nvmax=19)
coef(regfit.best,10)

# Now try cross-validation instead of test set.  
# Will need to construct a predict function for regsubsets.

# Predict function for RegSubsets
predict.regsubsets<-function(object,newdata,id,...){
  form<-as.formula(object$call[[2]])
  mat<-model.matrix(form,newdata)
  coefi<-coef(object,id=id)
  xvars<-names(coefi)
  mat[,xvars]%*%coefi
}

# Cross Validation
k<-10
set.seed(1)
folds<-sample(1:k,nrow(hitters),replace=T)
cv.errors<-matrix(NA,k,19,dimnames=list(NULL,paste(1:19)))


for(j in 1:k){
  best.fit<-regsubsets(Salary~.,data=hitters[folds!=j,],nvmax=19)
  for(i in 1:19){
    pred<-predict(best.fit,hitters[folds==j,],id=i)
    cv.errors[j,i]<-mean((hitters$Salary[folds==j]-pred)^2)
  }
}

mean.cv.errors<-apply(cv.errors,2,mean)
mean.cv.errors
par(mfrow=c(1,1))
plot(mean.cv.errors,type="b",pch=19,col=10)
apply(cv.errors,1,which.min)

# Again, apply decision to full data set for final model.
reg.best<-regsubsets(Salary~.,data=hitters,nvmax=19)
coef(reg.best,11)

# Lab 2 Ridge Regression and Lasso
x<-model.matrix(Salary~.,hitters)
y<-hitters$Salary
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
round(predict(ridge.mod,s=50,type="coef")[1:20,],3)

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
round(predict(out,type="coef",s=bestlam)[1:20,],4)

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
lasso.coef<-predict(out,type="coef",s=bestlam)[1:20,]
lasso.coef
lasso.coef[lasso.coef!=0]

# Lab 3: PCR and PLS Regression.
library(pls)
set.seed(2)
pcr.fit<-pcr(Salary~.,data=hitters,scale=T,validation="CV")
summary(pcr.fit)
validationplot(pcr.fit,val.type="MSEP")
set.seed(1)
pcr.fit<-pcr(Salary~.,data=hitters,subset=train,scale=T,validation="CV")
validationplot(pcr.fit,val.type="MSEP")
pcr.pred<-predict(pcr.fit,x[test,-1],ncomp=7)
mean((pcr.pred-y.test)^2)
pcr.fit<-pcr(y~x[,-1],scale=T,ncomp=7)
summary(pcr.fit)

# Partial Least Squares
set.seed(1)
pls.fit<-plsr(Salary~.,data=hitters,subset=train,scale=T,validation="CV")
summary(pls.fit)
validationplot(pls.fit,val.type="MSEP")
pls.pred<-predict(pls.fit,x[test,-1],ncomp=2)
mean((pls.pred-y.test)^2)
pls.fit<-plsr(Salary~.,data=hitters,scale=T,ncomp=2)
summary(pls.fit)