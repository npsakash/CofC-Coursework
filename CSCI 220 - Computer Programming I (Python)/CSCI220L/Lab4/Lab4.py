"""
Lab 3 - Graphics
Name: Neal Sakash
"""


## Discussion #3, Graphics chapter of Zelle text
## Moves a circle based on user clicks
## Comments added: RHS

from graphics import *

def squares():
    """  <---  You can use tripled quotes to write a multi-line comment....

    Modify the following function to:

    Draw squares (20 X 20) instead of circles. Make sure that the center of the square
    is at the point where the user clicks. Make the window 400 by 400.

    Have each successive click draw an additional square on the screen (rather
    than just moving the existing one).

    Display a message on the window "Click again to quit" after the loop, and
    wait for a final click before closing the window.
    """
    #Creates a graphical window
    width = 400
    height = 400
    win = GraphWin("Lab 4", width, height)

    #number of times user can move circle
    numClicks = 5

    #create a space to instruct user
    instPt = Point(width/2, height-10)
    instructions = Text(instPt,"Click to create a square")
    instructions.draw(win)

    #builds a square
    shape = Rectangle(Point(190, 190), Point(210,210))
    shape.setOutline("red")
    shape.setFill("red")
    shape.draw(win)

    #allows the user to click multiple times to copy the
    #square
    for i in range(numClicks):
        p = win.getMouse()
        c = shape.getCenter() #center of square
        #shapeN = shape.clone()

        dx = p.getX() - c.getX()
        dy = p.getY() - c.getY()
        shapeN = shape.clone()
        shapeN.move(dx, dy)
        shapeN.draw(win)
        #move amount is distance from center of circle to the
        #point where the user clicked
 #       dx = p.getX() - c.getX()
#        dy = p.getY() - c.getY()
        

    instructions.setText("Click again to close")
    win.getMouse()
    win.close()

#squares()

##def main():
##    squares()
def rectangle():

    width = 400
    height = 400
    win = GraphWin("Rectangle", width, height)

    instructPoint = Point(width//2, height - 20)
    instructions = Text(instructPoint, "Click on window twice to draw a square.")
    instructions.draw(win)

    clickPt1 = win.getMouse()
    clickPt2 = win.getMouse()

    rect = Rectangle(clickPt1, clickPt2)
    rect.setOutline("green")
    rect.setFill("green")
    rect.draw(win)

    length = abs(clickPt1.getX() - clickPt2.getX())
    height = abs(clickPt1.getY() - clickPt2.getY())

#    print(length)
 #   print(width)
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

#rectangle()

from math import *

def circle():

    width = 400
    height = 400
    win = GraphWin("Circle", width, height)

    instructPoint = Point(width//2, height - 20)
    instructions = Text(instructPoint, "Click on window to draw a circle.")
    instructions.draw(win)

    clickPt1 = win.getMouse()
    clickPt2 = win.getMouse()
    center = clickPt1
    circ = sqrt((clickPt2.getX() - clickPt1.getX())**2 + (clickPt2.getY() - clickPt1.getY())**2)

    circle = Circle(clickPt1, circ)
    circle.setFill('green')
    circle.setOutline('green')
    circle.draw(win)

    instructions.setText("Click again to close")
    win.getMouse()
    win.close()

#circle()    

def pi2():

    terms = eval(input("Enter your number of terms:"))

    num = 4
    denom = 1
    total = 0
    sign = 1
    for i in range(terms):
        approxPi = (num / denom) * sign
        total = total + approxPi
        denom = denom + 2
        sign = sign * -1    
        print("Approximation of pi = ", total)

    dif = pi - total

    print( "Difference from actual pi =", dif)

#pi2()
        
def pi():

    terms = eval(input("Enter your number of terms:"))
    num = 2
    denom = 1
    approxPi = 1
    
    for i in range(terms):
        num =+ num + (i%2)*2
        #approxPi = num/denom
        denom = denom + ((i+1)%2)*2
        approxPi = num/denom
        #print(num)
        #print(denom)
        
    total =+ approxPi*2
    print("Approximation of pi = ", total)

#pi()

#main()"""
