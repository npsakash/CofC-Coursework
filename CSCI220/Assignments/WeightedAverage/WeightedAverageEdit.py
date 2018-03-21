"""---------------------------------------------------------------------
Author:    Neal Sakash

Purpose:   Write a program that asks the user to read a file of grades,
           computes and prints each students average, class average, and
           an average of the individual grades
           
Authenticity:   I certify that this lab is entirely my work.
---------------------------------------------------------------------"""
def weightedAverage():

    #Purpose of the program
    print("This program reads a file consisting of a class's roster,")
    print("their grades, and the grade's weight within an average.")
    print()
    print("The program then outputs each student's weighted average and")
    print("the class's total average")
    print()
    
    #User inputs the file to be read
    file = input("Please enter the name of your file: ")
    print()

    #Open file
    inFile = open(file)
    
    #ignore header lines
    for i in range(3):
        line = inFile.readline()

    #references for class average
    classAvgTot = 0
    students = 0
    
    #Output message
    print("Below is the student roster with weighted grade averages")
    print()
        
    #loop through file
    for line in inFile:
        lineParts = line.split()
        students += 1
        
        #find name
        name = lineParts[0:2]
        fullName = " ".join(name)
        print(fullName + "'s average: ", end="")

        #Isolate Values
        values = lineParts[2:]

        #Value for Weight and Grade
        weightList = []
        gradeList = []
        for i in range(0,len(values),2):
            weights = values[i]
            weightList += weights.split()
            #print(weightList, end=" ")

            grades = values[i+1]
            gradeList += grades.split()
            #print(gradeList, end=" ")
           

        #Calculate weighted average for each student
        num = 0
        for i in range(0,len(gradeList)):
            num += (int(gradeList[i]) * int(weightList[i]))
                        
        #Constant for weight
        SUM_WEIGHTS = 100

        #Output
        average = num/SUM_WEIGHTS
        averageRound = round(average,1)
        print(averageRound)

    #Calcualte and output class average
        classAvgTot += average
    classAvg = classAvgTot/students
    classAvgRound = round(classAvg,1)
    print()
    print("Class Average: ",end = "")
    print(classAvgRound)

    #Close opened file
    inFile.close()
    
weightedAverage()

