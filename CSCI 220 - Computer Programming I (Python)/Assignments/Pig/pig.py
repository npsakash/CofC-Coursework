"""---------------------------------------------------------------------
Author:    Neal Sakash

Purpose:   'Implement a modular solution for the dice game Pig, with the
           user playing against the computer. Call the file pig.py.
           On each turn the current player rolls a pair of dice and
           accumulates points equal to the pips showing. The object is
           to be the first to reach 100 points. If the player rolls a 1
           on either die, all points for that turn are lost and the turn
           passes to the other player. If the player rolls two 1's
           ("snake eyes"), all points accumulated thus far in the game
           are lost,  and the turn passes to the other player.'

           'The player may turn over control of the dice voluntarily
           after any roll. So the player must decide whether to roll
           again (be a pig) and risk losing points, or give up the dice
           and risk having the other player win. Implement the computer
           player so that it gives up the dice after accumulating 20 or
           more points in a given turn, or rolling a 1.'


Authenticity:   I certify that this assignment is entirely my work.
---------------------------------------------------------------------"""

"""---------------------------------------------------------------------
                             Libraries
---------------------------------------------------------------------"""
import random

"""---------------------------------------------------------------------
                             Modular Fuctions
---------------------------------------------------------------------"""
#Function that simulates the rolling of one die
def roll():
    return random.randint(1,6)

#Function that controls the interactive play of the user
def playerPlays(totalPlayerPoints):
    playerPoints = 0
    
    die1 = 0 
    die2 = 0
    count = 0
    print("Total Player Points: ", str(totalPlayerPoints))
    turn = input("Would you like to roll this turn? ")
    print()
    #loop to run the interactive player's turn
    while turn[0] == "y":
        die1 = roll()
        die2 = roll()
        print("Player's roll =", str(die1) + " & "  + str(die2))
        #conditionals for each roll
        if die1 == 1 and die2 == 1:
            totalPlayerPoints = 0
            playerPoints = 0
            print("Player losses all game points")
            print("Total Points = 0\n")
            turn = "n"
        elif die1 == 1 or die2 == 1:
            playerPoints = 0
            print("Player losses all points this turn\n")
            turn = "n"
        else:
            playerPoints += die1 + die2
            print("Player points this turn = ", str(playerPoints))
            turn = input("Roll again? ")
            print()
            
    
    totalPlayerPoints += playerPoints
    return totalPlayerPoints

#Function that controls the automated play of the computer
def computerPlays(totalComputerPoints):
    computerPoints = 0
    
    die1 = 0 
    die2 = 0
    turn = "yes"
    #loop to run the computer's turn
    while turn[0] == "y" and computerPoints < 20 :
        die1 = roll()
        die2 = roll()
        print("Computer's Roll = ", str(die1) + " & " + str(die2))
        #Conditionals for computer's roll
        if die1 == 1 and die2 == 1:
            totalComputerPoints = 0
            computerPoints = 0
            print("Computer losses all game points")
            print("Total Points = 0\n")
            turn = "n"
        elif die1 == 1 or die2 == 1:
            computerPoints = 0
            print("Computer losses all points this turn\n")
            turn = "n"
        else:
            computerPoints += die1 + die2
            print("Computer Points this turn= ", str(computerPoints))
            print()
                        
    totalComputerPoints += computerPoints
    return totalComputerPoints                        

#Function that defines the gameplay of Pig   
def playPig():
    totalPlayerPoints = 0
    totalComputerPoints = 0
    count = 0
    #Loop that initializes the play of Pig
    while totalPlayerPoints < 100 and totalComputerPoints < 100:
        count += 1
        print("*************************************")
        print("Player's round: ", str(count))
        print()
        totalPlayerPoints = playerPlays(totalPlayerPoints)   
        print("Total Player Points: ", str(totalPlayerPoints))
        print("*************************************")
        print()

        #nested 'if' inside to continue computer play
        if totalPlayerPoints < 100:
            print("*************************************")
            print("Computer's round: ", str(count))
            print()
            totalComputerPoints = computerPlays(totalComputerPoints)
            print("Total Computer Points: ", str(totalComputerPoints))
            print("*************************************")
            print()
    #conditional for the winner of the game
    if totalPlayerPoints >= 100:
        print("*************************************")
        print("*     Total Player Points:",str(totalPlayerPoints),"     *")
        print("*        !!!Player Wins!!!          *")
        print("*************************************")
    else:
        print("*************************************")
        print("*    Total Computer Points:",str(totalComputerPoints),"    *")
        print("*       !!!Computer Wins!!!         *")
        print("*************************************")
        
        
"""---------------------------------------------------------------------
                             Main Fuction
---------------------------------------------------------------------"""
#Main function that asks the user to play the game of Pig
def main():
    print("*************************************")
    print("*    Welcome to the game of Pig!    *")
    print("*************************************\n")
    play = input("Would you like to play the game? ")
    print()
    #loop for the start of the game
    while play[0] == "y":
        playPig()
        play = input("Would you lile to play again? ")
    
"""---------------------------------------------------------------------
                             End of Program
---------------------------------------------------------------------"""
main()        


    
    
