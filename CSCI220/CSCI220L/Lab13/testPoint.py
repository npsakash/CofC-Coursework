# testPoint.py
# Author: Pharr

from Point import Point

def main():
    # Use this to test the constructor
    
    p1 = Point()

    # Use these to test the getters
    
    print ("Default p1 x =", p1.getX())
    print ("Default p1 y =", p1.getY())

    # Use these to test the setters
    
    p1.setX(1)
    p1.setY(2)
    print ()
    print ("Modified p1 x =", p1.getX())
    print ("Modified p1 y =", p1.getY())

    # Use this to test the __str__
    
    print ()
    print ("Modified Point p1 =", p1)

main()
