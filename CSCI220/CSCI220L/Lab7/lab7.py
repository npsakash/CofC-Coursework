# Lab7.py
# Name 1: Neal Sakash
# Name 2: Sasha Pramesti

import math

def numberWords():
    infile = open("rawWords.txt")
    outfileName = "numberedWords.txt"
    outfile = open(outfileName, "w")

    partsAccumulator = []
    for line in infile:
        parts = line.split()
        partsAccumulator += parts

    for i in range(len(partsAccumulator)):
        number = i+1
        print (str(number) + ". " + partsAccumulator[i], file = outfile)

    print("Data written to: " + outfileName)
    infile.close()
    outfile.close()

"""-------------------------------------------------------------------------"""

def hourlyWage(infileName, outfileName):

    #hourlyWage("hourlyWages.txt")
    infile = open(infileName)
    outfile = open(outfileName, "w")

    raiseAmt = 1.65
    
    for line in infile:
        parts = line.split()
        #print(parts)

        wage = eval(parts[2])
        newWage = raiseAmt + wage

        pay = eval(parts[3])*newWage
        payStr = str(round(pay,2))

        #print(pay)

        name1 = str(parts[0])
        name2 = str(parts[1])
        print(name1 + " " + name2 + " $" + payStr, file = outfile) 

    print("Data written to: " + outfileName)
    infile.close()
    outfile.close()
#hourlyWage()
"""-------------------------------------------------------------------"""
def nameValue(name):

    numberAcc = 0
    nameUpper = name.upper()
    for i in range(len(name)):
        number = (ord(nameUpper[i])- (ord("A")-1))
        numberAcc += number
        
    return numberAcc
    
"""-----------------------------------------------------------------------"""
def sphereArea(radius):

    area = (4*math.pi*radius**2)
    return area
def sphereVolume(radius):

    volume = ((4/3)*math.pi*radius**3)

    return volume
"""------------------------------------------------------------------------"""

def sumN(n):

    total = 0
    for i in range(n):
        total += i+1

    return total

def sumNCubes(n):

    total = 0
    for i in range(n):
        total += (i+1) **3

    return total
    

"""------------------------------------------------------------------------"""
def main():
    #nameInput = nameValue("Neal")
    newWages = hourlyWage("hourlyWages.txt", "newWages.txt")
    print("This code gives your name a numerological value")
    #print("value is: " + numberAcc)
    
    print("This code outputs spherical area and volume from a given radius")
    areaOutput = sphereArea(3)
    volumeOutput = sphereVolume(3)
    print("area is: " + str(areaOutput))
    print("volume is: " + str(volumeOutput))

    print("This code sums up the first n natural numbers")
    sum1 = str(sumN(10))
    print("Sum is: " + sum1)
    
    print("This code sums up the cubes of the first n natural numbers")
    sum2 = str(sumNCubes(10))
    print("Sum is: " + sum2)

main()

#main() should be the only file executed when you are checked off for this lab
#thus add code to main() to call any functions you write.


    
