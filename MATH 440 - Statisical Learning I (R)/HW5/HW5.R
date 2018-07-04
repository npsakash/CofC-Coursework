library(glmnet)
#Neal Sakash
#HW5

#Question Three




cars04<-read.csv("C:/Users/Neal/Documents/CofC/2017/Fall/MATH 440/HW5/cars04.csv",header=T)
head(cars04)


#a)
cars04$Hybrid<-ifelse(cars04$Hybrid==1,1,2)
pairs(cars04[,3:13], main="Cars04 Scatter Plot Matrix", col=cars04$Hybrid)

#b)
cars<-cars04[,2:13]
View(cars)
cars.lm<-lm(SuggestedRetailPrice~., data=cars)
summary(cars.lm)

#c)
library(gam)

gam.lm<-gam(SuggestedRetailPrice ~ DealerCost+Cylinders+s(CityMPG,4)+s(HighwayMPG,4)+s(Weight,3)+s(WheelBase,3)+s(EngineSize,3)+Width, data = cars)
summary(gam.lm)
plot(gam.lm,se=TRUE)
preplot(gam.lm)

anova(cars.lm,gam.lm, test = "Chisq")

##########################

cars04<-cars04[,-1]
head(cars04)
cars04.log1<-glm(SuggestedRetailPrice~.,data=cars04)
summary(cars04.log1) 
cla<-glm(SuggestedRetailPrice~DealerCost,data=cars04)
summary(cla)
curve(exp(cla$coef[1]+cla$coef[2]*x)/(1+exp(cla$coef[1]+cla$coef[2]*x)),lwd=3,col=10,xlim=range(cars04$DealerCost),ylab="Prob of SRS", xlab = "Dealer Cost")

# Spline model for cars04 Data.

library(splines)
library(gam)

o<-order(cars04$HighwayMPG)
cars04<-cars04[o,]


cnsa.2<-gam(Hybrid~s(HighwayMPG,df=2),data=cars04)
summary(cnsa.2)
plot(cnsa.2,se=T,col=12,lwd=3)
points(cars04$HighwayMPG,predict(cnsa.2,type="response"),type="l",col=12,lwd=3)
plot(cnsa.2,se=T,col=12,lwd=3)

cnsa.10<-gam(Hybrid~s(HighwayMPG,df=10),family=binomial,data=cars04)
summary(cnsa.10)
points(cars04$HighwayMPG,predict(cnsa.10,type="response"),type="l",col=11,lwd=3)
plot(cnsa.10,se=T,col=12,lwd=3)


cnsa.4<-gam(Hybrid~s(HighwayMPG,df=4),family=binomial,data=cars04)
summary(cnsa.10)
points(cars04$HighwayMPG,predict(cnsa.10,type="response"),type="l",col=13,lwd=3)
plot(cnsa.4,se=T,col=12,lwd=3)

anova(cnsa.2,cnsa.4,cnsa.10)

# Hastie Model
cars04.full.ns<-gam(Hybrid~ns(CityMPG,df=4)+ns(HighwayMPG,df=4)+ns(EngineSize,df=4)+ns(Horsepower,df=4)+ns(Weight,df=4),data=cars04,family=binomial)
summary(cars04.full.ns)
par(mfrow=c(3,2))
plot(cars04.full.ns,se=T,lwd=3,col="green")

# Using Step GAM
cars04.step<-step.gam(cars04.full.ns,scope=list("CityMPG"=~1+CityMPG+ns(CityMPG,2)+ns(CityMPG,4),"HighwayMPG"=~1+HighwayMPG+ns(HighwayMPG,2)+ns(HighwayMPG,4),"EngineSize"=~1+EngineSize+ns(EngineSize,2)+ns(EngineSize,4),"Horsepower"=~1+Horsepower+ns(Horsepower,2)+ns(Horsepower,4),"Weight"=~1+Weight+ns(Weight,2)+ns(Weight,4)))
summary(cars04.step)
par(mfrow=c(2,2))
plot(cars04.step,se=T,lwd=3,col="green")
