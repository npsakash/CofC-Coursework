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
    secretWord.lower()
    return secretWord

def guessedWord(secretWord, guessedCh):
    count = 0
    blank = ['_ '] * len(secretWord)

    ch = input("Guess a character? ")
    
    for i, ch in range(len(secretWord)):
        if ch in secretWord:
            count += 1
            blank.insert(count-1, ch)
            blank.pop(count)
            if count == len(secretWord):
                return "".join(str(e) for e in blank)
            else:
                count += 1
                blank.insert(count-1,"_")
                blank.pop(count)
                if count == len(secretWord):
                    return "".join(str(e) for e in blank)

                
       
    while missed < 6:
        guessedCh = input("guess a letter: ")
        wordGuessed += guessedCh
        if wordGuessed != secretWord:
            for ch in secretWord:
                if ch in wordGuessed:
                    secretWord.replace(ch,guessedCh)
                    print(guessedCh, end = " ")
                else:
                    missed += 1
                    print("_", end=" ")
                print()

        if missed == 0:
            print("win")
        else:
            

        return secretWord
    
    
def playHangman():

    words = getWords()
    #print(words)
    
    secretWord = wordSelection(words)
    print(secretWord)
    for ch in secretWord:
        print("_" , end=" ")
    print()

    while missed < 6:
        guessedCh = input("guess a letter: ")
        wordGuessed += guessedCh
        if wordGuessed != secretWord:
            for ch in secretWord:
                if ch in wordGuessed:
                    secretWord.replace(ch,guessedCh)
                    print(guessedCh, end = " ")
                else:
                    missed += 1
                    print("_", end=" ")
                print()

        if missed == 0:
            print("win")

        return secretWord


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
