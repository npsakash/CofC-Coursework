## Neal Sakash
## lab3.py

from graphics import *

#Problem One
#Calculate the average of a group of numbers per assignment instructions
def average():
    print("This program finds the average for homework assignments")
    print()
    
    hwCount = eval(input("Number of homework assignments: "))
    totalGrades = 0
    
    for i in range(1, hwCount + 1):
        score = "Enter your grade on HW" + str(i) + ":"  
        grade = eval(input(score))
        totalGrades = totalGrades + grade

    average = totalGrades/i
    print(average)

#average()


#Question Two
def fibonacci():

    fib1 = 0
    fib2 = 1
        
    upBound = eval(input("Enter the range of the sequence: "))
    for i in range(upBound):
        fibNew = fib1 + fib2
        print(fib1)
        fib1 = fib2

        fib2 = fibNew


#Question Three
def newton():

    xTerm = eval(input("Number?"))
    numApprox = eval(input("How many sqrt approximations?"))
    valApprox = xTerm/2
        
    for i in range(1, numApprox + 1):
        valApprox = ((valApprox + (xTerm/valApprox))/2)

    print(valApprox)

#Problem Four
def clickCircles():
    winWidth = 300
    winHeight = 400
    win = GraphWin("Click a point", winWidth, winHeight)

    instructPoint = Point(winWidth//2, winHeight - 20)
    instructions = Text(instructPoint, "Click on window to draw a point.")
    instructions.draw(win)
    for i in range(5):
        clickPt = win.getMouse()
        circ = Circle(clickPt, 30)
        circ.setFill('green')
        circ.setOutline('green')
        circ.draw(win)


    instructions.setText("Click again to exit.")
    win.getMouse()
    win.close()
    
#clickCircles()

def buildHouse():

    winWidth = 300
    winHeight = 400
    win = GraphWin('house', winWidth, winHeight)

    win.setBackground('blue')

    base = Rectangle(Point(winWidth*.33,winHeight*.75), Point(winWidth*.66,winHeight*1))
    base.setFill('white')
    base.draw(win)

    roof = Polygon(Point(winWidth*.33,winHeight*.75), Point(winWidth*.66,winHeight*.75), Point(winWidth*.5,winHeight*.5))
    roof.setFill('brown')
    roof.draw(win)    

buildHouse()

def sequence():

    terms = eval(input("Enter your number of terms:"))

    total = 0
    for i in range(terms):
        total = total + (i%2)*2
        
        print(total)


        
#sequence()
