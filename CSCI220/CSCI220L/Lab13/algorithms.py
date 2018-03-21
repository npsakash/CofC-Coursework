##Lab 13 Alexandra and Neal

## Q3
##The binary search was always faster. With a large amount of elements
##the difference was very noticable. With a smaller amount of elements
##the linear search was just as fast.

## Q5
##With a list of 10000 elements our sort took 8.17 seconds while
##Python's sort only took 0.003 seconds

def readData(fileName):

    inFile = open(fileName)

    dataList = []
    for line in inFile:
        dataList += line.split()

    for i in range(len(dataList)):
        dataList[i] = int(dataList[i])
        

    return dataList

def isInLinear(searchVal, values):

    i = 0
    while i < len(values) and values[i] != searchVal:
        i += 1

    if i == len(values):
        rtnVal = False
    else:
        rtnVal = True

    return rtnVal

def isInBinary(searchVal, values):
    low = values[0]
    high = len(values) - 1
    mid = (low + high)//2
    while low <= high and values[mid] != searchVal:
        if searchVal < values[mid]:
            high = mid - 1
        else:
            low = mid + 1
        mid = (low + high)//2
    if values[mid] == searchVal:
        rtnVal2 = True
    else:
        rtnVal2 = False

    return rtnVal2
            

def selSort(values):
    n = len(values)

    front = 0
    for front in range(0, n-1):
        minPos = front

        for i in range(front+1, n):
            if values[i]< values[minPos]:
                minPos = i

        temp = values[minPos]
        values[minPos] = values[front]
        values[front] = temp

    
    
    

def main():
    
    fileName = "dataSorted.txt"

    values = readData(fileName)
    print(values)
    searchVal = 80

    rtnVal = isInLinear(searchVal, values)

    if rtnVal == True:
        print("Found in list")
    else:
        print("Not found")

    rtnVal2 = isInBinary(searchVal, values)

    if rtnVal2 == True:
        print("Found in list")
    else:
        print("Not found")
    

    values2 = [5, 2, 9, 3, 1]
    selSort(values2)
    print(values2)
main()
