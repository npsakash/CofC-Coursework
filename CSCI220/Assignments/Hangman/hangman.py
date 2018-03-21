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

##winHeight = 400
##winWidth = 400
##win = GraphWin("Hangman", winHeight, winWidth)
##
##win.setCoords(0.0, 0.0, 100.0, 100.0)

"""---------------------------------------------------------------------
                             Modular Fuctions
---------------------------------------------------------------------"""
def getWords():

    inFile = open("wordlist.txt")
    lineList = inFile.readlines()

    return lineList

def wordSelection(lineList):
    
    num = random.randint(0,len(lineList)-1)
    secretWord = lineList[num]
    secretWord.split()
    return secretWord

def guessedWord(secretWord):
    secretWord.lower()
    #print(secretWord)
    missed = 0
    wordGuessed = []
    
    guess = input("guess a letter: ")
    wordGuessed += guess

    for ch in secretWord:
        if ch in wordGuessed:
            print(ch)
        else:
            print("_", end=" ")
            missed += 1
    print()

    if missed == 0:
        print("win")
    
    
def playHangman():

    words = getWords()
    #print(words)
    
    secretWord = wordSelection(words)
    print(secretWord)
    for ch in secretWord:
        print("_" , end=" ")
    print()


    wordGuessed = []
    while wordGuessed != secretWord:
        print()
        guessedWord(secretWord)
        print()
        
"""---------------------------------------------------------------------
                             Main Fuction                                
---------------------------------------------------------------------"""
def main():

    playHangman()
        
    

    
    
    
    
main()
