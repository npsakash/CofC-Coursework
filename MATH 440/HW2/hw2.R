bodyFat<-read.csv("C:/Users/Neal/Documents/CofC/2017/Fall/MATH 440/HW2/BodyFatLM.csv", header=T)

head(bodyFat)
#Full
bodyFat.lm<-lm(bodyfat~neck+chest+abdomen+hip+thigh+knee+ankle+biceps+forearm+wrist,data=bodyFat)
summary(bodyFat.lm)
#bfat.null=lm(bodyFat~1, data = bodyFat)
#x<-model.matrix(bodyfat~chest+abdomen+hip+neck+thigh+knee+ankle+biceps+forearm+wrist,data=bodyFat)
#y<-bodyFat$bodyfat
?step
#Forward
bodyFatForward.lm<-step(bodyFat.lm,direction="forward")
summary(bodyFatForward.lm)

#Backward
bodyFatBackward.lm<-step(bodyFat.lm,direction="backward")

summary(bodyFatBackward.lm)

#Both
bodyFatBoth.lm<-step(bodyFat.lm,direction="both")
summary(bodyFatBoth.lm)

#anova(bodyFat.lm,bodyFatNew.lm)


library(glmnet)
x<-model.matrix(bodyfat~.,data=bodyFat)
ridge.mod<-glmnet(x,y,alpha=0,lambda=grid)
corMatr<-cor(bodyFat)
round(corMatr,2)
grid<-10^seq(10,-2,length=100)
plot(ridge.mod,lwd=2)
