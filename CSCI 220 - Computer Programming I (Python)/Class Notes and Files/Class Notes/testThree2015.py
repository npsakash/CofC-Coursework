#testThree2015

#Question Two

import math

def distance(ptA, ptB, ptC, ptD):

    dis1x = ptB.getX()-ptA.getX()
    dis1y = ptB.getY()-ptA.getY()
    dis1 = sqrt((dis1x)**2 + (dis1y)**2)

    dis2x = ptD.getX()-ptC.getX()
    dis2y = ptD.getY()-ptC.getY()
    dis2 = sqrt((dis1x)**2 + (dis1y)**2)

    if dis1 == dis2:
        return True
    else:
        return False

#Question Three

def cellCount(wbc, rbc):

    if wbc > 11000 or rbc > 5:
        print("Too high")
    elif wbc >= 4500 and wbc <= 11000 and rbc >= 3.5 and rbc <= 5:
        print("Normal")
    elif wbc <4500 or rbc < 3.5:
        print("Too low")


#Quesiton Four

def password():

    pwd = input("pass? ")
    while len(pwd) < 8 and len(pwd) > 14 and pwd[0] == "*":
        print("Incorrect syntax")
        pwd = input("Pass? ")
        print(pwd)
        
        
def main():

    #cellCount(5000, 3.0)
    password()
    
main()
    
