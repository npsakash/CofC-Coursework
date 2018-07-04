#HW4 Neal Sakash

head(trees)
myTrees = trees

#Create new Row && Add Values
myTrees["Girth*Height"] = 0

for(row in 1:nrow(myTrees)){
  myTrees[row,4]= myTrees[row,1]*myTrees[row,2]
}

# Linear model Volume predicted by girth, height & girth*height
lin.mod1 = lm(Volume ~., data = myTrees)
ln.mod1.summary = summary(lin.mod1)
ln.mod1.summary

#Bootstrapping 
library(boot)
tree.glm = glm(Volume~Girth+Height+Girth*Height, data =myTrees)
tree.glm.summary = summary(tree.glm)

boot.fn = function(data, index){
  return(coef(lm(Volume~., data = myTrees, subset= index)))
}

boot.fn(myTrees,sample(96,96,replace=T))

boot1 = boot(myTrees, boot.fn, 1000)
print(boot1)
summary(myTrees)$coef



#2
library(MASS)

data2 = Pima.tr

#2a Logistic Regression
log.reg.mod = glm(type~., family= binomial(link='logit'), data=data2)
summary(log.reg.mod)
log.reg.pred = predict(log.reg.mod,data2)

#2b LDA

library(pls)
lda1 = lda(type~., data = data2)
plot(lda1)

lda1.pred = predict(lda1,data2)
names(lda1.pred)
lda1.pred.class1 = lda1.pred$class
table(lda1.pred.class1, data2$type)
mean(lda1.pred.class1!=data2$type)

#2c QDA
qda1 = qda(type~., data = data2)
qda1.pred = predict(qda1, data2)
names(qda1.pred)
qda1.class1 = qda1.pred$class
table(qda1.class1, data2$type)  
mean(qda1.class1!=data2$type)
#2d


#2e