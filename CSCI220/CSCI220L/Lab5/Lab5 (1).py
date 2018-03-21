# Lab5.py
# Name 1: Neal Sakash
# Name 2: Sydney Lovice

from graphics import *
from math import *

def cupConverter():
    # Author: RoxAnn H. Stalvey, modified by Walter Pharr
    # Illustrates getting numeric input through graphics window
    winWidth = 300
    winHeight = 200
    win = GraphWin("Convert cups to milliliters", winWidth, winHeight)

    #Specify the message for the input box
    boxDesc = Text(Point(100, 50), "Input cups: ")
    boxDesc.draw(win)

    #Create the Entry object and set its default text to a number
    #  allowing the user to see what type of value is expected
    inp = Entry(Point(200, 50), 5)
    inp.setText("0")
    inp.draw(win)

    #Create a Text object for outputting the result
    output = Text(Point(150, 150), "")
    output.draw(win)

    #Unit Conversions
    CUPS_TO_OZ = 8
    OZ_TO_ML = 29.57
    
    #This button isn't necessary, but it makes a nice point for the user
    #  to click.  If you click anywhere in the window, the code reacts
    #  the same way.
    btPtX = winWidth/2
    btPtY = winHeight/2
    button = Text(Point(btPtX, btPtY), "Click")
    button.draw(win)
    border = Rectangle(Point(btPtX-35, btPtY-20), Point(btPtX+35, btPtY+20))
    border.draw(win)

    # Wait for a mouse click
    win.getMouse()

    # Discover intput and convert it to a number
    # If numeric input wasn't needed, simply omit the eval()
    cups = eval(inp.getText())

    #Calculate milliliter equivalent here
    ounces = cups * CUPS_TO_OZ
    ml = ounces * OZ_TO_ML
    
    # Display output and change button
    output.setText("value entered = " + str(cups) + "cups")

    
    output.setText("Click for milliliter conversion")
    
    #win.getMouse()

    output.setText("milliliters = " + str(ml) + "ml")
    
    button.setText("Quit")
    
    # Wait for another click to exit
    win.getMouse()
    win.close()

def target():
    winWidth = 200
    winHeight = winWidth
    win = GraphWin("Archery Target", winWidth, winHeight)
    win.setCoords(0.0, 0.0, 10.0, 10.0)
    center = Point(5, 5)
    center.draw(win)

    circle1 = Circle(center, 5)
    circle1.setFill("white")
    circle1.draw(win)

    circle2 = Circle(center, 4)
    circle2.setFill("black")
    circle2.draw(win)

    circle3 = Circle(center, 3)
    circle3.setFill("blue")
    circle3.draw(win)

    circle4 = Circle(center, 2)
    circle4.setFill("red")
    circle4.draw(win)

    circle5 = Circle(center, 1)
    circle5.setFill("yellow")
    circle5.draw(win)

    instructions = Text(Point(5, 1), "Click to close")
    instructions.draw(win)
    # Wait for another click to exit
    win.getMouse()
    win.close()


def triangle():
    winWidth = 500
    winHeight = 500
    win = GraphWin("Draw a Triangle", winWidth, winHeight)

    # Add code here to accept the mouse clicks, draw the triangle.
    # and display its area in the graphics window.
    instructPoint = Point(winWidth//2, winHeight - 20)
    instructions = Text(instructPoint, "Click on window three times to draw a triangle.")
    instructions.draw(win)

    clickPt1 = win.getMouse()
    clickPt2 = win.getMouse()
    clickPt3 = win.getMouse()

    triangle = Polygon(clickPt1, clickPt2, clickPt3)
    triangle.setOutline("green")
    triangle.setFill("green")
    triangle.draw(win)

    #LineA
    dx1 = clickPt2.getX()-clickPt1.getX()
    dy1 = clickPt2.getY()-clickPt1.getY()
    lineA = sqrt((dx1)**2 + (dy1)**2)
    #LineB
    dx2 = clickPt3.getX()-clickPt2.getX()
    dy2 = clickPt3.getY()-clickPt2.getY()
    lineB = sqrt((dx2)**2 + (dy2)**2)
    #LineC
    dx3 = clickPt1.getX()-clickPt3.getX()
    dy3 = clickPt1.getY()-clickPt3.getY()
    lineC = sqrt((dx3)**2 + (dy3)**2)

    print(lineA)
    print(lineB)
    print(lineC)

    per = lineA + lineB + lineC
    s = per/2
    area = sqrt(s*(s-lineA)*(s-lineB)*(s-lineC))
    
    
    instructions.setText("Click again for perimeter")
    win.getMouse()
    msg = "Perimeter is: "+ str(per) + " pixles"
    msg += "\nClick again for area"
    instructions.setText(msg)
    win.getMouse()

    msg2 = "Area is: "+ str(area) + " pixles squared"
    msg2 += "\nClick again to close"
    instructions.setText(msg2)
    
    win.getMouse()
    win.close()
    #print(length)
 #  print(width)
 
    per = 2*length + 2*height
    area = length*width

    instructions.setText("Click again for perimeter")
    win.getMouse()
    msg = "Perimeter is: "+ str(per) + " pixles"
    msg += "\nClick again for area"
    instructions.setText(msg)
    win.getMouse()

    msg2 = "Area is: "+ str(area) + " pixles squared"
    msg2 += "\nClick again to close"
    instructions.setText(msg2)
    
    win.getMouse()
    win.close()


    # Wait for another click to exit
    win.getMouse()
    win.close()

def colorShape():
    '''Create code to allow a user to color a shape by entering rgb amounts'''

    #create window
    winWidth = 400
    winHeight = 400
    win = GraphWin("Color Shape", winWidth, winHeight)
    win.setBackground("white")

    #create text instructions
    msg = "Enter color values between 0 - 255\nClick window to color shape"
    inst = Text(Point(winWidth/2, winHeight-20), msg)
    inst.draw(win)
    
    #create circle in window's center
    shape = Circle(Point(winWidth/2, winHeight/2 - 30), 50)
    shape.draw(win)

    #redTexPt is 50 pixels to the left and forty pixels down from center
    redTextPt = Point(winWidth/2 - 50, winHeight/2 + 40)
    redEntry = Entry(Point(winWidth/2 - 5, winHeight/2 + 40), 5)
    redEntry.setText("0")
    #red = eval(redEntry.getText())
    redEntry.draw(win)
    redText = Text(redTextPt, "Red: ")
    redText.setTextColor("red")
    redText.draw(win)
    
    #greenTextPt is 30 pixels down from red
    greenTextPt = redTextPt.clone()
    greenTextPt.move(0,30)
    greenEntry = Entry(Point(winWidth/2 - 5, winHeight/2 + 70), 5)
    greenEntry.setText("0")
    #green = eval(greenEntry.getText())
    greenEntry.draw(win)
    greenText = Text(greenTextPt, "Green: ")
    greenText.setTextColor("green")
    greenText.draw(win)

    #blueTextPt is 60 pixels down from red
    blueTextPt = redTextPt.clone()
    blueTextPt.move(0,60)
    blueEntry = Entry(Point(winWidth/2 - 5, winHeight/2 + 100), 5)
    blueEntry.setText("0")
    #blue = eval(blueEntry.getText())
    blueEntry.draw(win)
    blueText = Text(blueTextPt, "Blue: ")
    blueText.setTextColor("blue")
    blueText.draw(win)

    win.getMouse()
    
    red = eval(redEntry.getText())
    green = eval(greenEntry.getText())
    blue = eval(blueEntry.getText())

    shape.setFill(color_rgb(red, green, blue))
    
    #display rgb text
    #redText.draw(win)
    #greenText.draw(win)
    #blueText.draw(win)

def anotherSeries():
    total = 0
    n = eval(input("Number of terms: "))
    for i in range(n):
        total += ((n%3)+1)*2
        print(total, end = " + ")
    
def main():
#    cupConverter()
    target()
#    triangle()
#    colorShape()







