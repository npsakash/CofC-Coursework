# CSCI 220L - Lab 8 Solutions
#
# Name 1: Ellinor Walters
#
# Name 2: Neal Sakash
#

def formatPractice():
    print("it's raining {1} and {0}".format('dogs', 'cats'))
    print("{0:4.2f} {1:05.3f}".format(2.3,.4567))
    print("{0:02}:{1:05.2f}".format(3, 7.4589))
    print("{0} {1}: {2:5.2f}".format("Steph", "Curry", 43.75432))
    
#formatPractice()

def ecode():

    word = input("Enter a word: ")
    key = eval(input("Enter key number: "))
    codeWord =""
    
    for ch in word:
        ch2 = chr(ord(ch) + key)
        codeWord += ch2
    print(codeWord)

#ecode()

def encodeBetter():
    
    word = input("Enter a word: ")
    key = eval(input("Enter key number: "))
    for letVal in range(ord("a"), ord("z")+1:
        abc += chr(letVal)

    alphabet = "abcdefghijklmnopqrstuvwxyz"*key
    codeWord =""
    for ch in word:
        ch2 = ord(ch) + key
        chMod = chr(ch2)%26
        codeWord += chMod
    print(codeWord)

encodeBetter()


def addTen(nums):
    for i in range(len(nums)):
        nums[i] += 10
    
    
#function to test code in problem 4.  Do not run
#until addTen() is written




def squareEach(nums):
    for i in range(len(nums)):
        num = nums[i]
        nums[i] = num**2
    
def sumOfList(nums):
    total = 0
    for i in range(len(nums)):
        num = nums[i]
        total += num
    return total
    
def toNumbers(strList):
    for i in range(len(strList)):
        num = str(strList[i])
        num = eval(num)


def sumOfSquares():
    values = [5, 2, -3]
    print(values)
    squareEach(values)
    print(values)
    print(sumOfList(values))
    print(toNumbers(values))
    


    #print(values)
##def testTens():
##    values = [5, 2, -3]
##    print(values)
##    sumOfSquares(values)
##    print(values)

#testTens()

sumOfSquares()
    
    

