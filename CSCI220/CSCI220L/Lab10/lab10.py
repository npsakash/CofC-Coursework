# CSCI 220L - Lab 10 Solutions
#
# Name 1: Courtney Beckham
#
# Name 2: Neal Sakash
#
import math
from random import randint

#Question 1
def calculateSum(value, numIterations):
    total = 0
    count = 0
    while count < numIterations:
        total += value
        count += 1
    return total

def areEqual(num1, num2):
    if abs(num1-num2) < 0.0001:
        return True
    else:
        return False

#Question Two
def goodInput():
    num = eval(input("Enter number: "))
    while num < 1 or num > 10 and num !=-1 and num <50:
        print("Num must be between 1-10, equal to -1, or greater than 50.")
        num = eval(input("enter number: "))

    return num

#Question Three
def numDigits():

    num= eval(input("Enter a positive integer: "))
    while num > 0:
        #num= eval(input("Enter a positive integer: "))
        count = 0
        while num > 0:
            num = num // 10
            count += 1
        
        print("digits: ", count)
        num= eval(input("Enter a positive integer: "))
    print("Must be a positive number")


#Question Four
def hiLoGame():
    num = randint(1,100)
    guess = eval(input("Enter a number between 1 and 100: "))
    count= 1
    while count < 7 and num != guess:

        
        if guess > num:
            print("Too high")
        elif guess < num:
            print("too low")
        count += 1
        guess = eval(input("Enter a number between 1 and 100: "))
        
    if guess == num:
        print("Correct!")
        print("you win in " + str(count) + " guesses!")
        
    else:        
        print("sorry, you lose. The number was " , num)

def main():
    result= calculateSum(.1, 10)
    equals= areEqual(1.0, result)
    if equals == True:
        print("The two numbers are equal.")
    else:
        print("The two numbers are NOT equal.")

    good = goodInput()
    print(good)

    numDigits()

    hiLoGame()

main()
