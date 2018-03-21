"""---------------------------------------------------------------------
Author:    Neal Sakash

Purpose:   Write a program, bumper.py, that creates two circles of
           different colors and chooses initial random directions for
           them to move. If either circle hits a wall, that circle
           should move away from the wall (in the opposite direction
           of the wall). If the circles collide have both circles change
           total opposite direction.

Authenticity:   I certify that this assignment is entirely my work.
---------------------------------------------------------------------"""

"""---------------------------------------------------------------------
                             Libraries
---------------------------------------------------------------------"""
from graphics import *
from math import *
from time import sleep
import random

"""---------------------------------------------------------------------
                             Graph Window
---------------------------------------------------------------------"""

winHeight = 400
winWidth = 400
win = GraphWin("Bumper Cars", winHeight, winWidth)

win.setCoords(0.0, 0.0, 100.0, 100.0)

"""---------------------------------------------------------------------
                             Modular Fuctions
---------------------------------------------------------------------"""

#Car Movement Function
def getMoveAmount():
    amt = random.random()*random.randint(-5,5)
    return amt

#Car Vertical Collision Functiony
def hitVertical(ball, win):

    ballP1 = ball.getP1()
    ballP1Y = ballP1.getY()

    ballP2 = ball.getP2()
    ballP2Y = ballP2.getY()

    if ballP1Y <= 0 or ballP1Y >= 100:
        returnValVert = True
    elif ballP2Y <= 0 or ballP2Y >= 100:
        returnValVert = True
    else:
        returnValVert = False
    return returnValVert
        
#Car Horizontal Collision Function    
def hitHorizontal(ball, win):

    ballP1 = ball.getP1()
    ballP1X = ballP1.getX()

    ballP2 = ball.getP2()
    ballP2X = ballP2.getX()

    if ballP1X <= 0 or ballP1X >= 100:
        returnValHor = True
    elif ballP2X <= 0 or ballP2X >= 100:
        returnValHor = True
    else:
        returnValHor = False
    return returnValHor

#Car Collision Function
def didCollide(ball,ball2):

    cent1 = ball.getCenter()
    cent2 = ball2.getCenter()
    rad1 = ball.getRadius()
    rad2 = ball2.getRadius()
    
    dist1x = cent1.getX()-cent2.getX()
    dist1y = cent1.getY()-cent2.getY()
    cirDis = sqrt((dist1x)**2 + (dist1y)**2) 
    radCom = rad1 + rad2

    if cirDis <= radCom:
        returnVal = True
    else:
        returnVal = False
    return returnVal

#Random Color Function
def randColor():
    color = random.randint(0,255)
    return color

"""---------------------------------------------------------------------
                             Main Fuction                                
---------------------------------------------------------------------""" 

def main():

    instPt = Point(50, 10)
    instructions = Text(instPt,"Click to begin program")
    instructions.draw(win)
    win.getMouse()
    instructions.undraw()
    
    #First Car 
    center = Point((random.randint(25,75)),(random.randint(25,75)))
    firstCar = Circle(center,5)
    firstCar.setFill('blue')
    firstCar.setOutline('black')
    firstCar.draw(win)

    #Second Car
    secondCar = firstCar.clone()
    secondCar.move((random.randint(-20,20)),(random.randint(-20,20)))
    secondCar.setOutline('black')
    secondCar.setFill('yellow')
    secondCar.draw(win)

    #Car Movement
    dx1 = getMoveAmount()
    dy1 = getMoveAmount()
    dx2 = getMoveAmount()
    dy2 = getMoveAmount()

    #Initialization Loop
    for i in range(500):
        firstCar.move(dx1,dy1)
        secondCar.move(dx2,dy2)
        sleep(.25)

        #Randomized color upon impact
        red = randColor()
        blue = randColor()
        green = randColor()

        red2 = randColor()
        blue2 = randColor()
        green2 = randColor()

        #Car Collision Conditional
        if didCollide(firstCar,secondCar):
            dx1 = -dx1
            dy1 = -dy1
            dx2 = -dx2
            dy2 = -dy2
            firstCar.setFill(color_rgb(red,green,blue))
            secondCar.setFill(color_rgb(red2,green2,blue2))

        #Vertical Collision Conditional
        if hitVertical(firstCar, win):
            dx1 = dx1
            dy1 = -dy1
            firstCar.setFill(color_rgb(red,green,blue))
        if hitVertical(secondCar, win):
            dx2 = dx2
            dy2 = -dy2
            secondCar.setFill(color_rgb(red2,green2,blue2))

        #Horizontal Collision Conditional
        if hitHorizontal(firstCar, win):
            dx1 = -dx1
            dy1 = dy1
            firstCar.setFill(color_rgb(red,green,blue))
        if hitHorizontal(secondCar, win):
            dx2 = -dx2
            dy2 = dy2
            secondCar.setFill(color_rgb(red2,green2,blue2))

    Text(Point(50, 10), "Click to Close").draw(win)
    w = win.getMouse()
    win.close()
    print("\nDone")        
    
main()

    
