##Exercise 3 p. 160
from graphics import*

def main():
    win = GraphWin("Face", 200, 200)
    winWidth = win.getWidth()
    winHeight = win.getHeight()

    head = Circle(Point(100, 90), 90)
    head.setOutline("pink")
    head.setFill("pink")
    head.draw(win)
