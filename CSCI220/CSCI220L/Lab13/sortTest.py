# Code compares runtimes of selection sort and Python's built-in sort
# Author: RoxAnn H. Stalvey


from algorithms import *
from random import randint
import time

def main():
    print("Code to look at runtime for selection sort vs. Python's list sort.")
    
    numDig = 5 #number of digits to output
    
    #large list with numElements elements
    numElements = 10000
    data = []
    data2 = [] 
    for i in range(numElements):
        num = randint(1, numElements)
        data.append(num)
        data2.append(num)
        
    print("\nSorting list with " + str(len(data)) + " elements.\n")
    
    start = time.time()
    selSort(data)
    end = time.time()
    print("Selection sort -> " + str(round(end - start, numDig)) + " seconds.")
        
    start = time.time()
    data2.sort()
    end = time.time()
    print("Python's sort -> " + str(round(end - start, numDig)) + " seconds.")

main()
