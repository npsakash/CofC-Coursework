##cdTime.py
##CSCI 220
##Neal Sakash
##January 27th, 2016

##This fuction calculates the total time on a cd and a collection of cds

def cdTime():

    MIN_TO_HOUR = 60 #Minutes to hour conversion
    SEC_TO_MIN = 60 #second to minute conversion

    #Asks for number of CDs to run program for
    numCD = eval(input("Number of albums?: "))

    total = 1
    for j in range(numCD):

    #Asks for the amount of tracks to total
        print("For Album", j+1)
        numTracks = eval(input("Number of tracks on album?: "))

        totalMin = 0
        totalSec = 0

        #Asks for the minutes and seconds of each track
        for i in range(numTracks):
            print("For Track", i+1)
            numMinutes = eval(input("Number of minutes on track?: "))
            numSeconds = eval(input("Number of Seconds on track?: "))
            
            #Tabulates minutes and seconds together
            totalMin = totalMin + numMinutes
            totalSec = totalSec + numSeconds
            secInt = totalSec//SEC_TO_MIN
            secRem = totalSec%SEC_TO_MIN

            
        #calculates total time for album    
        print("CD", j+1, "Total time: ", totalMin+secInt,"minutes",secRem,"seconds")

    #Calculates total time for all albums
    #I've had the most trouble with this part. My totals are not adding up right
    totalMin += numMinutes
    totalSec += numSeconds

    colHours = totalMin // MIN_TO_HOUR
    minRem = totalMin % MIN_TO_HOUR
    secRem = totalSec//SEC_TO_MIN
    colMinutes = minRem + secRem
    colseconds = totalSec % SEC_TO_MIN
    print("Total time for all CDs:", colHours,"Hours",colMinutes,"minutes",colseconds,"seconds")

cdTime()       
