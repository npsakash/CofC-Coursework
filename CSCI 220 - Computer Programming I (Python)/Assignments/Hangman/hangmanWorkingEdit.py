"""---------------------------------------------------------------------
Author:    Neal Sakash

Purpose:   Hangman

Authenticity:   I certify that this assignment is entirely my work.
---------------------------------------------------------------------"""

"""---------------------------------------------------------------------
                             Libraries
---------------------------------------------------------------------"""
from graphics import *
from math import *
import random

"""---------------------------------------------------------------------
                             Graph Window
---------------------------------------------------------------------"""
#Graphical Window
winHeight = 600
winWidth = 600
win = GraphWin("Hangman", winHeight, winWidth)

win.setCoords(0.0, 0.0, 100, 100)

#Parts of the hanged man to be displayed after an incorrect guess
head = Circle(Point(50,80), 10)
body = Line(Point(50,70), Point(50,60))
arm1 = Line(Point(50,65), Point(40,65))
arm2 = Line(Point(50,65), Point(60,65))
leg1 = Line(Point(50,40), Point(30,55))
leg2 = Line(Point(50,65), Point(70,55))
noose = Line(Point(50,75), Point(50,85))

###Text areas
remainingLetterBox1 = Text(Point(15,20), "Remaining Choices:")
remainingLetterBox2 = Text(Point(52.5,20),"")
textArea3= Text(Point(17,10),"Choose a letter: ")
textArea4= Text(Point(52.5,93),"")
textArea4.setSize(12)
textArea5= Text(Point(50,71),"")
textArea5.setSize(12)
textArea6= Text(Point(25,50),"Click to Continue")
textArea6.setSize(12)
textArea6.setTextColor("blue")
textArea7= Text(Point(75,50),"Click to Quit")
textArea7.setSize(20)
textArea7.setTextColor("red")

#Fancy submit button with shading
submitBttnTxt = Text(Point(170, 525), "Submit")
submitBttnTxt.draw(win)
submitBttn = Rectangle(Point(140,515), Point(200, 535))
submitBttn.setOutline("Black")
submitBttn.draw(win)
submitBttn1=Line(Point(140,535),Point(204,535))
submitBttn1.setWidth(4)
submitBttn1.setOutline("DimGray")
submitBttn1.draw(win)
submitBttn2=Line(Point(202,515),Point(202,535))
submitBttn2.setWidth(4)
submitBttn2.setOutline("DimGray")
submitBttn2.draw(win)

#Mask for background of "Game Over" screen.
backDrop = Rectangle(Point(0,0),Point(winWidth,winHeight))
backDrop.setFill("gray")


"""---------------------------------------------------------------------
                             Modular Fuctions
---------------------------------------------------------------------"""
def getWords():

    inFile = open("wordlist.txt", "r")
    lineList = inFile.readlines()

    return lineList

def wordSelection(lineList):
    
    num = random.randint(0,len(lineList)-1)
    secretWord = lineList[num]
    #secretWord = secretWord.split()
    secretWord = secretWord.lower()
    secretWord = secretWord.strip()
    return secretWord

#def guessedWord():
    

def playHangman():
    #loads secret word into game
    wordList = getWords()
    secretWord = wordSelection(wordList)
    remainingLetters =list("abcdefghijklmnopqrstuvwxyz")
    remainingDisplay = " ".join(remainingLetters)

    spaces = len(secretWord)
    textArea5.setText(spaces)

    remainingLetterBox1.draw(win)
    remainingLetterBox2.draw(win)
    textArea3.draw(win)
    textArea4.draw(win)
    textArea5.draw(win)
    
    
    print(secretWord)

    secretWord = list(secretWord)
    correctWord = False
    correctGuess = False
    guesses = 0

    while correctWord == False:
        guessBox = Entry(Point(30,10), 2)
        guessBox.setText("")
        guessBox.draw(win)
        remainingLetterBox2.setText(remainingDisplay)
        click = win.getMouse()
        click = click.getX()

        while click <75 or click > 67:
            click = win.getX()
            click = click.getText()
        guessedCh = guessBox.getText()
        guessedCh = guessedCh.lower()

        if guessedCh in remainingLetters:
            remainingLetters.remove(guessedCh)
            remainingDisplay = remainingDisplay.replace(guessedCh, "_")
            
            for i in range(len(secretWord)):
                if secretWord[i] == guessedCh:
                    spaces = list(spaces)
                    spaces[i*2] = secretWord[i]
                    spaces = "".join(spaces)    
                    correctGuess = True
            
            #Incorrect guess results in decrease of remGuess counter
            #and provides feedback.
            if correctGuess == False:
                guesses += 1
                part = parts[guesses]
                part.draw(win)
                remGuess = 7 - guessNum
                textArea4.setTextColor("red")
                textArea4.setText("Oh No! That's not a letter in the word.")
                spaces = ''.join(blanks)

            #Correct guess results in user feedback.
            else:
                correctGuess=False
                textArea4.setTextColor("blue")
                textArea4.setText("Fantastic! Guess again.")
                textArea5.setText(spaces)

        #Provides feedback if guess was previously input.
        else:
            textArea4.setTextColor("black")
            textArea4.setText("That letter was already guessed. Try again.")
            remainingDisplay = " ".join(remainingDisplay)

        guessBox.undraw()
        correctWord = gameOver(spaces,guessNum)
        
    return spaces

def gameOver(spaces,guessNum):
    notFilled = blanks.count("_")
    if notFilled > 0 and guessNum < 7:
        winState = False
    else:
        winState = True
    return winState
    

#Main
def main():
    
    #win=GraphWin("Hangman",winWidth,winHeight)

    #Fancy submit button with shading
    submitBttnTxt = Text(Point(170, 525), "Submit")
    submitBttnTxt.draw(win)
    submitBttn = Rectangle(Point(140,515), Point(200, 535))
    submitBttn.setOutline("Black")
    submitBttn.draw(win)
    submitBttn1=Line(Point(140,535),Point(204,535))
    submitBttn1.setWidth(4)
    submitBttn1.setOutline("DimGray")
    submitBttn1.draw(win)
    submitBttn2=Line(Point(202,515),Point(202,535))
    submitBttn2.setWidth(4)
    submitBttn2.setOutline("DimGray")
    submitBttn2.draw(win)

    #Mask for background of "Game Over" screen.
    backDrop = Rectangle(Point(0,0),Point(winWidth,winHeight))
    backDrop.setFill("gray")

    #Function calls
    playHangman()

    
#########################################################################
####_______This is a cheat that displays the word in the Shell______#####
#############_______________YOU ARE WELCOME________________##############
#########################################################################
    print ("This is the word: ",word)####################################
#########################################################################
    
    blanks = numSpaces(word)
    blanks=playGame(word,blanks,win)

    #Checks Game Over State
    notFilled = blanks.count("_")
    backDrop.draw(win)
    textArea6.draw(win)
    textArea7.draw(win)
    
    if notFilled == 0:
        message = Text(Point(300, 200), "Congrats")
        message.setSize(36)
        message.draw(win)
    else:
        parts = [leg1,leg2,body,arm1,arm2,head,rope1,rope2]
        for part in parts:
            part.undraw()
            part.draw(win)
        message = Text(Point(300, 210), "Try Again?")
        message.setSize(36)
        message.draw(win)

    
    #Waits for user to click inside bounds of either button.
    choice = False
    while choice == False:
        click = win.getMouse()
        click = click.getX()
        if click > 45 and click < 255:
            win.close()
            main()

        if click < 525 and click > 375:
            choice = True


    win.close()
main()


"""
    #guessing the word
    
    guessedWord = ""
    attempts = 6 
    
    while attempts > 0:
        incorrect = 0
                        
        for ch in secretWord:
            if ch in guessedWord:
                print(str(ch), end= " ")
            else:
                print(str("_"), end= " ")
                incorrect += 1
        print(len(secretWord))
        print()
        
                    
        guessedCh = input("Guess a letter: ")
        guessedWord += guessedCh

        if guessedWord == secretWord:
            print("You win!")
            

        elif guessedCh not in secretWord:
            attempts -= 1
            print("Sorry, wrong guess")
            print(str(attempts) , "many guesses left")
            print()
            if attempts == 0:
                print("Sorry you lose. The secret word was", str(secretWord))
                
        
"""        

"""---------------------------------------------------------------------
                             Main Fuction                                
---------------------------------------------------------------------"""
##def main():
##
##    playHangman()
##        
##    
##
##    
##    
##    
##    
##main()
