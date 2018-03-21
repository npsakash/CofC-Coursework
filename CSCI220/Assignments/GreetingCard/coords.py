from graphics import *

winWidth = 400
winHeight = 400
win = GraphWin("tic-tac-toe", winWidth, winHeight)

win.setCoords(0.0, 0.0, 10.0, 10.0)

Line(Point(1,0), Point(1,3)).draw(win)

arrow = Polygon(Point(2.0,2.0), Point(3.0,2.5), Point(2.1,2.2), Point(2.0, 3.0)) 
arrow.draw(win)
arrow.setFill('purple')

rect = Rectangle(Point(2.0,4.0), Point(5.0,5.0))
rect.setFill('purple')
rect.draw(win)

arrowTwo = arrow + rect
arrowTwo.draw(win)
