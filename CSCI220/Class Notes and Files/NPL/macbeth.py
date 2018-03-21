def macbeth():

#nameOpenFileConnection = open("macbeth.txt")

    inFile = open('macbeth.txt')
    #print(inFile)

    #File sequence loop
    for line in inFile:
        lineNoReturn = line[:-1]
        count = len(lineNoReturn)
        #print("char in file", count)
        print("\"" + lineNoReturn + " has " + str(count) + " characters")
        
macbeth()
