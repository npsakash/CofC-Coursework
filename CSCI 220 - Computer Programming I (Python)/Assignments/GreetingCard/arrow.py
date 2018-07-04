from graphics import *

winHeight = 600
winWidth = 600
win = GraphWin("Arrow", winHeight, winWidth)

win.setBackground('red')

arrow = Polygon(Point(100,200), Point(150, 240), Point(125, 205), Point(300, 205), Point(300, 195), Point(125, 195), Point(150, 160))
arrow.setFill('purple')
arrow.draw(win)

message = Text(Point(winWidth/2, winHeight-10))
message.draw(win)
message.setText("Click on window to move arrow to that point")

for count in range(5):
    mousePt = win.getMouse()
    centerPt = arrow.getCenter()
    newX = mousePt.getX() - centerPt.getX()
    newY = mousePt.getY() - centerPt.getY()
    arrow.move(newX, newY)
