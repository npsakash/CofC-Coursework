from graphics import*
import random
from time import sleep

winHeight = 600
winWidth = 600
win = GraphWin("Valentine's Day Card", winHeight, winWidth)

circles = []
for i in range(5):
    clickPt = win.getMouse()
    cir = Circle(clickPt, 30)
    cir.draw(win)
    cir.setWidth(2)
    cir.setOutline('white')
    cir.setFill('red')
    
win.getMouse()

for i in range(10):
    for cir in circles:
        cir.move(10,0)
    time.sleep(0.2)
