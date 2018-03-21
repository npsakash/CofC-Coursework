##Class notes January 19th

def factorial():
    upBound = eval(input("What num for factorials?"))
    fact=1
    for i in range(upBound):
        fact *= i+1
    print(upBound, "! =", fact)

def sibCount():
    numPeople = eval(input("Number of people to poll: "))

    total = 0
    for i in range(numPeople):
        numSib = eval(input("Num siblings?"))
        total += numSib
        average = total / numPeople
                            
        print("Total siblings: ", total)
                            
        print("Average number of siblings: ", average)
