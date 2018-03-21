def readFile():

#nameOpenFileConnection = open("macbeth.txt")

    inFile = open('data.txt')
    #print(inFile)

    #File sequence loop
    for line in inFile:
        lineNoReturn = line[:-1]
        count = len(lineNoReturn)
        #print("char in file", count)
        print("\"" + lineNoReturn + " has " + str(count) + " characters")
        
#readFile()

def readFile2():

#nameOpenFileConnection = open("macbeth.txt")

    #Open connection to file
    inFile = open('data.txt')
    #print(inFile)

    #initalize total count of siblings
    totalSib = 0
    
    #File sequence loop
    for line in inFile:
        lineNoReturn = line[:-1]
##        count = len(lineNoReturn)
##        print("char in file", count)
##        print("\"" + lineNoReturn + " has " + str(count) + " characters")
        #break line into list
        lineParts = line.split()
        #find num siblings
        numSib = eval(lineParts[1])
        #find name
        name = lineParts[0]
        
        print(lineNoReturn + " has " + string(numSib) + " sibs. ")

        #increment accumulator
        totalSib += numSib
    print("Total num sibs: " + str(totalSib))

readFile2()
