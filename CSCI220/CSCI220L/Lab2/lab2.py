
## lab2.py
## Purpose: Solves problems assigned in Lab 2
## Name: Neal Sakash 
import math

def helloWorld():
    print("Hello, world!")


#Question Two
def sumOfThrees():
    print("This function sums multiples of three.")
    
    upperBound = eval(input("Upperbound number?"))
    upBound = upperBound // 3
    total = 0
    for i in range(upBound + 1):
        total = total + i*3
        print("Final total:", total)

#Question Three
def multiplicationTable():
    print("This function prints out a multiplication table for numbers 1 through 12")

    for j in range(12):
        print(j+1,":",end="")

        for i in range(12):
            print((j+1)*(i+1), end=" ")
        print()
     
#Question Four            
def triangleArea():
    
    print("This function calculates the area of a triangle")

    sideA = eval(input("enter side A:"))
    sideB = eval(input("enter side B:"))
    sideC = eval(input("enter side C:"))

    s = (sideA + sideB + sideC)/2

    area = math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC))

    print("Area:", area)


#Question Five
def sumSquares():
    print("This function calculates the sum of squares")

    lowBound = eval(input("Lower Range:"))
    upBound = eval(input("Upper Range:"))

    total = 0
    for i in range(lowBound, upBound+1):
        square = i**2
        total += square
    print(total)
    
#Question Six

def power():

    print("This function manually calculates the powers of numbers")

    num = eval(input("Enter your base number:"))
    upBound = eval(input("Enter your exponent:"))

    total = 1
    for i in range(upBound):
        total *= num
        
    print(num, "^", upBound, "=", total)
                   
#Type each function here then call the function from main() below.
#Once the function is working correctly, you can put a comment symbol
#in front of the call in main() so that you don't have to see it run over
#and over.  An example helloWorld function is above with a commented out
#call to the working function below.
