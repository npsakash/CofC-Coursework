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
    
    return secretWord

def guessedWord(secretWord):

    chList = list(secretWord)
    
##    for ch in range(len(secretWord)):

    print(chList)
    chList.replace("_")

    return chList
    

    
    

"""---------------------------------------------------------------------
                             Main Fuction                                
---------------------------------------------------------------------"""
def main():

    words = getWords()
    #print(words)
    
    num = wordSelection(words)
    print(num)

    wordList = guessedWord(num)
#    print(wordList)

    
    
    
    
main()
