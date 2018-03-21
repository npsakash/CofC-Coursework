"""---------------------------------------------------------------------
Author:    Neal Sakash

Purpose:   Use the author's graphics package to create a
           Valentine's Day card that displays a heart, a greeting,
           and an animated arrow.

Authenticity:   I certify that this lab is entirely my work.
---------------------------------------------------------------------"""

"""---------------------------------------------------------------------
                             Libraries
---------------------------------------------------------------------"""
from graphics import *
from math import *
from time import sleep
import random
"""---------------------------------------------------------------------
                             Color Guide                                
                                                                   
dark pink - color_rgb(255, 0, 102)                                          
light pink - color_rgb(245, 157, 165)
medium pink - color_rgb(255, 51, 153)
light purple - color_rgb(255, 102, 255)
darker purple - color_rgb(230, 0, 172)
                                                                      
---------------------------------------------------------------------"""

"""---------------------------------------------------------------------
                             Graph Window
---------------------------------------------------------------------"""

winHeight = 600
winWidth = 600
win = GraphWin("Valentine's Day Card", winHeight, winWidth)

win.setCoords(0.0, 0.0, 100.0, 100.0)
"""---------------------------------------------------------------------
                             Coordinate Guide
                             
#x-axis
Text(Point(10.0, 1.0), '10.0').draw(win)
Text(Point(20.0, 1.0), '20.0').draw(win)
Text(Point(30.0, 1.0), '30.0').draw(win)
Text(Point(40.0, 1.0), '40.0').draw(win)
Text(Point(50.0, 1.0), '50.0').draw(win)
Text(Point(60.0, 1.0), '60.0').draw(win)
Text(Point(70.0, 1.0), '70.0').draw(win)
Text(Point(80.0, 1.0), '80.0').draw(win)
Text(Point(90.0, 1.0), '90.0').draw(win)
Text(Point(100.0, 1.0), '100.0').draw(win)

#y-axis
Text(Point(4.0, 10.0), '10.0').draw(win)
Text(Point(4.0, 20.0), '20.0').draw(win)
Text(Point(4.0, 30.0), '30.0').draw(win)
Text(Point(4.0, 40.0), '40.0').draw(win)
Text(Point(4.0, 50.0), '50.0').draw(win)
Text(Point(4.0, 60.0), '60.0').draw(win)
Text(Point(4.0, 70.0), '70.0').draw(win)
Text(Point(4.0, 80.0), '80.0').draw(win)
Text(Point(4.0, 90.0), '90.0').draw(win)
Text(Point(4.0, 100.0), '100.0').draw(win)

#Vertical Lines
Line(Point(10.0,0.0), Point(10.0,100.0)).draw(win)
Line(Point(20,0), Point(20,100)).draw(win)
Line(Point(30,0), Point(30,100)).draw(win)
Line(Point(40,0), Point(40,100)).draw(win)
Line(Point(50,0), Point(50,100)).draw(win)
Line(Point(60,0), Point(60,100)).draw(win)
Line(Point(70,0), Point(70,100)).draw(win)
Line(Point(80,0), Point(80,100)).draw(win)
Line(Point(90,0), Point(90,100)).draw(win)
Line(Point(100,0), Point(100,100)).draw(win)
#Horizontal Lines
Line(Point(0.0,10.0), Point(100.0,10.0)).draw(win)
Line(Point(0,20), Point(100,20)).draw(win)
Line(Point(0,30), Point(100,30)).draw(win)
Line(Point(0,40), Point(100,40)).draw(win)
Line(Point(0,50), Point(100,50)).draw(win)
Line(Point(0,60), Point(100,60)).draw(win)
Line(Point(0,70), Point(100,70)).draw(win)
Line(Point(0,80), Point(100,80)).draw(win)
Line(Point(0,90), Point(100,90)).draw(win)
Line(Point(0,100), Point(100,100)).draw(win)
--------------------------------------------------------------------"""

win.setBackground(color_rgb(255, 0, 102))

instPt = Point(50, 10)
instructions = Text(instPt,"Click")
instructions.setTextColor('white')
instructions.draw(win)
win.getMouse()

"""---------------------------------------------------------------------
                             Heart
---------------------------------------------------------------------"""

heartCurveOne = Circle(Point(40, 60), 10)
heartCurveOne.setFill(color_rgb(245, 157, 165))
heartCurveOne.setOutline(color_rgb(245, 157, 165))

heartCurveTwo = heartCurveOne.clone()
heartCurveTwo.move(20,0)

heartCurveOne.draw(win)
heartCurveTwo.draw(win)

heartBottom = Polygon(Point(31,55), Point(50,32.5), Point(69,55),
                      Point(50, 60))
heartBottom.setFill(color_rgb(245, 157, 165))
heartBottom.setOutline(color_rgb(245, 157, 165))
heartBottom.draw(win)

"""---------------------------------------------------------------------
                             Greeting
---------------------------------------------------------------------"""
instructions.setText("Click Again")
win.getMouse()

#instructions.undraw(win)

greeting = Text(Point(50,80), "Happy Valentine's Day!!!")
greeting.setFace('helvetica')
greeting.setSize(32)
greeting.setTextColor('white')
greeting.draw(win)

"""---------------------------------------------------------------------
                             Arrow
---------------------------------------------------------------------"""
instructions.setText("Click Again")
win.getMouse()

#Arrow Point
arrowPoint = Polygon(Point(70,70), Point(70,75), Point(72, 72),
                     Point(75,70))
arrowPoint.setFill('white')
arrowPoint.setOutline('white')
arrowPoint.draw(win)
#Arrow Shaft
arrowShaft = Polygon(Point(71,71), Point(70.5,71.5), Point(87,88),
                     Point(88,87), Point(71.5, 70.5))
arrowShaft.setFill('white')
arrowShaft.setOutline('white')
arrowShaft.draw(win)
#Arrow Fletching
#1
arrowFletch1 = Rectangle(Point(84,83), Point(89,84))
arrowFletch1.setFill('white')
arrowFletch1.setOutline('white')
arrowFletch1.draw(win)
#2
arrowFletch2 = Rectangle(Point(86,85), Point(91,86))
arrowFletch2.setFill('white')
arrowFletch2.setOutline('white')
arrowFletch2.draw(win)
#3
arrowFletch3 = Rectangle(Point(84,84), Point(83,89))
arrowFletch3.setFill('white')
arrowFletch3.setOutline('white')
arrowFletch3.draw(win)
#4
arrowFletch4 = Rectangle(Point(86,86), Point(85,91))
arrowFletch4.setFill('white')
arrowFletch4.setOutline('white')
arrowFletch4.draw(win)

#Arrow Movement
arrowList = [arrowPoint, arrowShaft, arrowFletch1, arrowFletch2,
             arrowFletch3, arrowFletch4]

ax = 1
ay = 1

for i in range(50):
    for arrow in arrowList:
        arrow.move(-ax,-ay)
        sleep(.01)
"""---------------------------------------------------------------------
                             Small Hearts
---------------------------------------------------------------------"""
#Small Reference Heart for Clones

smallHeart = Polygon(Point(50,45), Point(55,50), Point(55,53),
                     Point(54,55), Point(52,55), Point(50,53),
                     Point(48,55), Point(46,55), Point(45,53),
                     Point(45,50))
smallHeart.setFill(color_rgb(245, 157, 165))
smallHeart.setOutline(color_rgb(245, 157, 165))
smallHeart.draw(win)

n = 0
for i in range(10):
    n = i + i

#Clone 1
smallClone(n) = smallHeart.clone()
smallClone(n).move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone(n).setOutline('white')
smallClone(n).setFill('white')
smallClone(n).draw(win)

"""
#Small Reference Heart for Clones

smallHeart = Polygon(Point(50,45), Point(55,50), Point(55,53),
                     Point(54,55), Point(52,55), Point(50,53),
                     Point(48,55), Point(46,55), Point(45,53),
                     Point(45,50))
smallHeart.setFill(color_rgb(245, 157, 165))
smallHeart.setOutline(color_rgb(245, 157, 165))
smallHeart.draw(win)

#Clone 1
smallClone1 = smallHeart.clone()
smallClone1.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone1.setOutline('white')
smallClone1.setFill('white')
smallClone1.draw(win)

#Clone 2
smallClone2 = smallHeart.clone()
smallClone2.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone2.setOutline(color_rgb(255, 51, 153))
smallClone2.setFill(color_rgb(255, 51, 153))
smallClone2.draw(win)

#Clone 3
smallClone3 = smallHeart.clone()
smallClone3.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone3.setOutline(color_rgb(255, 102, 255))
smallClone3.setFill(color_rgb(255, 102, 255))
smallClone3.draw(win)

#Clone 4
smallClone4 = smallHeart.clone()
smallClone4.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone4.setOutline(color_rgb(230, 0, 172))
smallClone4.setFill(color_rgb(230, 0, 172))
smallClone4.draw(win)

#Clone 5
smallClone5 = smallHeart.clone()
smallClone5.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone5.setOutline('white')
smallClone5.setFill('white')
smallClone5.draw(win)

#Clone 6
smallClone6 = smallHeart.clone()
smallClone6.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone6.setOutline(color_rgb(255, 51, 153))
smallClone6.setFill(color_rgb(255, 51, 153))
smallClone6.draw(win)

#Clone 7
smallClone7 = smallHeart.clone()
smallClone7.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone7.setOutline(color_rgb(255, 102, 255))
smallClone7.setFill(color_rgb(255, 102, 255))
smallClone7.draw(win)

#Clone 8
smallClone8 = smallHeart.clone()
smallClone8.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone8.setOutline(color_rgb(230, 0, 172))
smallClone8.setFill(color_rgb(230, 0, 172))
smallClone8.draw(win)

#Clone 9
smallClone9 = smallHeart.clone()
smallClone9.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone9.setOutline('white')
smallClone9.setFill('white')
smallClone9.draw(win)

#Clone 10
smallClone10 = smallHeart.clone()
smallClone10.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone10.setOutline(color_rgb(255, 51, 153))
smallClone10.setFill(color_rgb(255, 51, 153))
smallClone10.draw(win)

#Clone 11
smallClone11 = smallHeart.clone()
smallClone11.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone11.setOutline(color_rgb(255, 102, 255))
smallClone11.setFill(color_rgb(255, 102, 255))
smallClone11.draw(win)

#Clone12
smallClone12 = smallHeart.clone()
smallClone12.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone12.setOutline(color_rgb(230, 0, 172))
smallClone12.setFill(color_rgb(230, 0, 172))
smallClone12.draw(win)

#Clone 13
smallClone13 = smallHeart.clone()
smallClone13.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone13.setOutline('white')
smallClone13.setFill('white')
smallClone13.draw(win)

#Clone 14
smallClone14 = smallHeart.clone()
smallClone14.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone14.setOutline(color_rgb(255, 51, 153))
smallClone14.setFill(color_rgb(255, 51, 153))
smallClone14.draw(win)

#Clone 15
smallClone15 = smallHeart.clone()
smallClone15.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone15.setOutline(color_rgb(255, 102, 255))
smallClone15.setFill(color_rgb(255, 102, 255))
smallClone15.draw(win)

#Clone 16
smallClone16 = smallHeart.clone()
smallClone16.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone16.setOutline(color_rgb(230, 0, 172))
smallClone16.setFill(color_rgb(230, 0, 172))
smallClone16.draw(win)

#Clone 17
smallClone17 = smallHeart.clone()
smallClone17.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone17.setOutline('white')
smallClone17.setFill('white')
smallClone17.draw(win)

#Clone 18
smallClone18 = smallHeart.clone()
smallClone18.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone18.setOutline(color_rgb(255, 51, 153))
smallClone18.setFill(color_rgb(255, 51, 153))
smallClone18.draw(win)

#Clone 19
smallClone19 = smallHeart.clone()
smallClone19.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone19.setOutline(color_rgb(255, 102, 255))
smallClone19.setFill(color_rgb(255, 102, 255))
smallClone19.draw(win)

#Clone 20
smallClone20 = smallHeart.clone()
smallClone20.move((random.randint(-50,50)),(random.randint(-50,50)))
smallClone20.setOutline(color_rgb(230, 0, 172))
smallClone20.setFill(color_rgb(230, 0, 172))
smallClone20.draw(win)
"""

"""
I tried running the many hearts in a loop to randomly move them but it
wasn't really working for me

clones = [smallClone1, smallClone2, smallClone3, smallClone4, smallClone5]
for i in range(10):
    for clone in clones:
        clone.move((random.randint(-50,50)),(random.randint(-50,50)))
        time.sleep(0.001)
"""

instructions.setText("Click anywhere to close")
win.getMouse()
win.close()
