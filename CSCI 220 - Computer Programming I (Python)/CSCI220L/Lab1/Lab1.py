##Lab1.py
##CSCI 220L
##Neal Sakash

##This function calculates the area of a rectangle
def calcArea():
    length = eval(input("Enter the length: "))
    width = eval(input("Enter the width: "))
    area = length*width
    print ("Area =", area)

##This function calculates volume
def calcVolume():
    length = eval(input("Enter the length: "))
    width = eval(input("Enter the width: "))
    height = eval(input("Enter the height: "))
    volume = length*width*height
    print ("Volume =", volume)

##This function calculates shooting percentage
def shootingPercentage():
    totalShots = eval(input("Enter your total shots: "))
    shotsMade = eval(input("Enter the total shots made: "))
    shootingPercentage = (shotsMade/totalShots)*100
    print ("Shooting percentage =", shootingPercentage)

##This function calculates total costs
def coffee():
    PRICE_PER_POUND = 10.50
    SHIPPING_PER_POUND = 0.86
    PRICE_PER_ORDER = 1.50
    pounds = eval(input("Enter your amount of coffee: "))                        
    totalCost = ((pounds*PRICE_PER_POUND)+(pounds*SHIPPING_PER_POUND)+PRICE_PER_ORDER)
    print("Total cost for this order: $", totalCost)

##This function coverts Kilometers to miles
def kilometersToMiles():
    KILOMETERS_TO_MILES = 1.61
    miles = eval(input("Enter your amount of kilometers: "))
    kM = (miles/KILOMETERS_TO_MILES)
    print("Distance from kilometers to miles: ", kM, "kM")
    
