Python 3.5.1 (v3.5.1:37a07cee5969, Dec  6 2015, 01:38:48) [MSC v.1900 32 bit (Intel)] on win32
Type "copyright", "credits" or "license()" for more information.
>>> from graphics import *
>>> win = GraphWin()
>>> p = Point(50,60)
>>> p.getX()
50
>>> p.getY()
60
>>> win = GraphWin()
>>> p.draw(win)
>>> p2 = Point(140,100)
>>> p2.draw(win)
>>> p2.draw(win)
Traceback (most recent call last):
  File "<pyshell#9>", line 1, in <module>
    p2.draw(win)
  File "C:\Users\Neal\AppData\Local\Programs\Python\Python35-32\graphics.py", line 396, in draw
    if self.canvas and not self.canvas.isClosed(): raise GraphicsError(OBJ_ALREADY_DRAWN)
graphics.GraphicsError: Object currently drawn
>>> win = GraphWin('shapes')
>>> center = Point(100,100)
>>> circ = Circle(center, 30)
>>> circ.setFill('red')
>>> circ.draw(win)
>>> #Square
>>> rect = Rectangle(Point(30,30), Point(70,70))
>>> rect.draw(win)
>>> ###Line
>>> line = Line(Point(20,30), Point(180, 165))
>>> line.draw(win)
>>> #oval
>>> oval = Oval(Point(20,150), Point(180,199))
>>> oval.draw(win)
>>> win = GraphWin()
>>> win = GraphWin('eyes')
>>> 
>>> 
>>> #Incorrect way to create two circles
>>> leftEye = Circle(Point(80, 50),5)
>>> leftEye.setFill('yellow')
>>> leftEye.setOutline('red')
>>> rightEye = leftEye
>>> rightEye.move(20,0)
>>> 
>>> #correct way
>>> leftEye = Circle(Point(80,50), 5)
>>> leftEye.setFill('yellow')
>>> leftEye.setOutline('red')
>>> rightEye = Circle(Point(100,50), 5)
>>> rightEye.setFill('yellow')
>>> rightEye.setOutline('red')
>>> 
>>> #using clone
>>> leftEye = Circle
