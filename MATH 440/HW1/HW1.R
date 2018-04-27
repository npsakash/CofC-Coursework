

###Chase Code###
jointData<-read.csv("C:/Users/Neal/Documents/CofC/2017/Fall/MATH 440/HW1/mydata.csv",header=T)
plot(jointData$x,jointData$y,pch=19,col="green",xlab = "x",ylab = "y")
df<-data.frame(list(x=jointData$x,y=jointData$y))
simple.lm<-lm(y~x,data = df)
summary(simple.lm)
abline(simple.lm)


#5
bodyFat<-read.csv("C:/Users/Neal/Documents/CofC/2017/Fall/MATH 440/HW1/BodyFatLM.csv", header=T)
head(bodyFat)
bodyFat.lm<-lm(bodyfat~neck+chest+abdomen+hip+thigh+knee+ankle+biceps+forearm+wrist,data=bodyFat)
summary(bodyFat.lm)
X<-model.matrix(bodyfat~chest+abdomen+hip+neck+thigh+knee+ankle+biceps+forearm+wrist,data=bodyFat)
X
xT<-t(X)
h=solve(xT%*%X)*19.34
h
#print("h")
bodyFatNew.lm<-lm(bodyfat~abdomen+wrist+neck+hip,data=bodyFat)
summary(bodyFatNew.lm)
anova(bodyFat.lm,bodyFatNew.lm)
