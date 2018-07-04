##interest.py
##CSCI 220
##Neal Sakash
##January 19th, 2016

##This fuction calculates monthly interest charges

def monthlyInterestCharge():
    annualIntRate = eval(input("Enter your annual percentage rate: "))
    billCycle = eval(input("Enter the days in billing cycle: "))
    prevBalance = eval(input("Enter your previous balance: "))
    payment = eval(input("Enter any payment made: "))
    paymentDate = eval(input("Enter the day the payment was made: "))

#Calculate balance from net balance multipled by billing cycle
    netBalanceCycle = prevBalance*billCycle

#Calculate balance from net payment multipled by adjusted billing cycle
    netPaymentCycle = (payment*(billCycle-paymentDate))

#Calculate adjusted balance from payments
    adjustedBalance = netBalanceCycle-netPaymentCycle

#Calculate average daily balance
    averageDailyBalance = adjustedBalance/billCycle

#Calculate monthly percentage rate
    monthlyPercentageRate = ((annualIntRate/12)*0.01)

#Calculate monthly interest charged
    interestCharged = averageDailyBalance*monthlyPercentageRate

#Display results
    print ("Your monthly interest charge is: $", interestCharged)
    

