#lab12.py
#Neal and Kendall

def reverseSort(List):
    List.sort()
    List.reverse()

##def main():
##    List = [14,11,12]
##    reverseSort(List)
##    print(List)

def findAndRemoveFirst(list, value):
    pos = list.index(value)
##    list.pop(pos)
##    list.insert(pos, "neal")

    list.remove(value)
    list.insert(pos, "neal")
    





def board():
    numbersList = [1,2,3,4,5,6,7,8,9]

    return numbersList

def display(numberList):
    print("_________")
    for i in range(len(numberList)):
        ch = numberList[i]
        d = ""
        if i != 2 and i != 5 and i != 8:
            d += str(ch) + " | "
        else:
            d += str(ch) + "\n_________\n"

        print(d, end = "")

def fill(numberList, entry, xOrO):
    if xOrO == "x" or xOrO == "o":
        pos = numberList.index(entry)
        numberList.remove(entry)
        numberList.insert(pos, xOrO)
        return numberList
        

def validEntry(entry,numberList):
    if entry > 0 and entry < 10 and numberList[entry-1] != "x" and numberList[entry-1] != "o":
        valid = True
    else:
        valid = False

def winner(display):
    return False

def gameOver(numberList):
    intCount = 0
    for i in range(len(numberList)):
        if type(numberList[i]) == int:
            intCount += 1

    if intCount == 0 or winner(numberList) == True:
        stopGame = True
    else:
        stopGame = False
    return stopGame
    
    
def play():
    numberList = board()
    endGame = gameOver(numberList)
    if endGame == False and winner(display(numberList)) == False:
        entry= eval(input("Player X-- Enter position: "))
        while validEntry(entry,numberList) == False:
            entry = eval(input("Player X-- Enter postition: "))
        xOrO = "X"
        fill(numberList, entry, xOrO)
        display(numberList)
        entry = eval(input("Player O-- Enter a position"))
        while validEntry(entry,numberList) == False:
            entry = eval(input("Player X-- Enter postition: "))
            xOrO = "O"
        fill(numberList,entry,xOrO)
        display(numberList)
        
        

play()
        
            
        
    
    
 
