#Class Notes 2-2-16

#Next homework assignment
    #Greeting Card
from graphics import *
import time

#Rectangle
#Square
def main():
    #center = (50,75)
    #width = 4

    ptA=Point(30,55)
    ptB=Point(70,95)
    sq=Rectangle(ptA,ptB)
    

def face():
    win=GraphWin("face", 200, 200)
    winWidth=win.getWidth()
    winHeight=win.getHeight()

    head=circle(Point(100, 90), 90)
    head.setOutline("pink")
    head.setFill("pink")

#
def witch():
    win = GraphWin("clicks", 400, 500)

    for i in range(20):
        clickPt = win.getMouse()
        clickPt.draw(win)
        print ("point(", end="")
        print(clickPt.getX(), clickPt.getY(), end="")
        print(")", end=",")


   
    win.getMouse()
    win.close()

def createShape():
    win = GraphWin("shape", 400, 500)
    shape = polygon(point(196, 149), Point(180, 214))
    shape.setFill("purple")
    shape.draw(win)
createShape()                
