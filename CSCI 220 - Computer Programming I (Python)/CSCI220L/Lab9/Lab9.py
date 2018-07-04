## Lab9.py
##
## Name 1:Courtney Beckham
##
## Name 2: Neal Sakash
##

from graphics import *
from math import sqrt

def starter(weight,numWin):
    """
    Ask for a wrestler's weight and number of wins, determine whether
    the wrestler is a starter.
    """
    retVal = False
    if weight >= 150 and weight < 160:
        if numWin >= 5:
            retVal = True
            
    if weight >= 199 or numWin > 20:
            retVal = True
            
    return retVal

def isValid(isbn):

    #isbn
    if type(isbn)==str and len(isbn) == 10:
        None
        sum=0
        for i in range(len(isbn)):
            ch= eval(isbn[i])
            countDown = 10 - i
                #print(countDown)
            sum += (ch * countDown)
            #print(sum)
        if sum%11 == 0:
            return True
        else:
            return False
    else:
        return False
    
        
    
                
def circleOverlap():
    """
    Draw two circles and determine whether they overlap.
    """
    #Build window
    winHeight = 400
    winWidth = 400
    win = GraphWin("Overlapping circles", winHeight, winWidth)

    #Text area for instructions for user
    instruct = Text(Point(winWidth/2, winHeight-10), "")
    instruct.draw(win)


    #Get center point and x/y for center
    instruct.setText("To draw a circle, click the centerpoint for the circle")
    center = win.getMouse()
    center.draw(win)
    cX = center.getX()
    cY = center.getY()

    #Get point on the circumference and its x/y coordinates
    instruct.setText("Click a point on the border of the circle.")
    border = win.getMouse()
    bX = border.getX()
    bY = border.getY()

    #Calculate radius using Euclidean distance
    radius = sqrt((cX-bX) ** 2 + (cY-bY) ** 2)
    circle = Circle(center, radius)
    circle.draw(win)

    #Circle Two
    #Get center point and x/y for center
    instruct.setText("To draw a circle, click the centerpoint for the circle")
    center2 = win.getMouse()
    center2.draw(win)
    cX2 = center2.getX()
    cY2 = center2.getY()

    #Get point on the circumference and its x/y coordinates
    instruct.setText("Click a point on the border of the circle.")
    border2 = win.getMouse()
    bX2 = border2.getX()
    bY2 = border2.getY()

    #Calculate radius using Euclidean distance
    radius2 = sqrt((cX2-bX2) ** 2 + (cY2-bY2) ** 2)
    circle2 = Circle(center2, radius2)
    circle2.draw(win)


    cent1=circle.getCenter()
    cent2=circle2.getCenter()
    
    dist1x = cent1.getX()-cent2.getX()
    dist1y = cent1.getY()-cent2.getY()
    cirDis = sqrt((dist1x)**2 + (dist1y)**2) 
    radCom = radius + radius2

    #instruct2 = Text(Point(winWidth/2, winHeight-30),"")
    
    if cirDis <= radCom:
        returnVal = True
        instruct.setText("Circles overlap")

    else:
        returnVal = False
        instruct.setText("Circles do not overlap")
#    return returnVal
    time.sleep(1)

    # Wait for another click to exit
    instruct.setText("Click anywhere to close.")
    win.getMouse()
    win.close()
    
def leapYear(year):
    if year%4 == 0:
        if year%100 != 0 or year%400 ==0:
            return True
        else:
            return False
    else:
        return False
def main():
    ''' Add code to test all of your functions '''
    start = starter(155,6)

    if start:
        print("You are eligible to start")
    else:
        print("You are not eligible to start")
      
##

    valid = isValid("91")
    if valid:
        print("This is a valid ISBN")
    else:
        print("This is not a valid ISBN")

    circleOverlap()

    leap= leapYear(2100)
    print(leap)
    if leap:
        print("This is a leap year.")
    else:
        print("This is not a leap year.")
    

    
main()

    

