#Point.py
#Alexandra and Neal

#Properties:
#

class Point:

    def __init__(self):
        self.X = 0
        self.Y = 0

    def getX(self):
        return self.X

    def getY(self):
        return self.Y

    def setX(self, val):
        if val > 0:
            self.X = val

    def setY(self, val):
        if val > 0:
            self.Y = val

    def __str__(self):
        string = "(" + str(self.X)+ "," + str(self.Y) + ")"
        return string

    


