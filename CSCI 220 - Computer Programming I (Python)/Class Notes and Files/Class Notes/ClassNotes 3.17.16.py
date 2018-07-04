#Notes March 17

#Selection

def main():
    age = eval(input("enter age:"))
    if age >= 18:
        print("you can vote")
        if age >= 21:
            print("legal to drink")
        else:
            print("no beer for you")
    else:
        print("you are too young to vote")

    print("\nDone")

#main()

def main2():
    age = eval(input("enter age:"))
    if age >= 18 and age >= 21:
        print("you can vote and drink")
    else:
        print("you can't do both")

    print("\nDone")

#main2()

def even():
    num = eval(input("enter number: "))
    if type(num) == int:
        if num%2 == 0:
            print('even')
        else:
            print("odd")
    else:
        print("can't determine if odd/even")
    print("\nDone")

#even()

def even2():
    num = eval(input("enter number: "))
    if type(num) == int and num%2 == 0:
        print('even')
    elif type(num) == int and not num%2 == 0: #also <and num%2 != 0:>
        print('odd')
    else:
        print("can't determine if odd/even")
    print("\nDone")

#even2()

def grade():
    avg = eval(input("enter grade:"))
    if avg >= 90 and avg <100:
        print("A")
    elif avg >=80 and avg <90:
        print("B")
    elif avg >=70 and avg <80:
        print("C")
    elif avg >=60 and avg <70:
        print("D")
    elif avg >=0 and avg <60:
        print("F")
    else:
        print("not a legit average")

#grade()

def grade2():
    avg = eval(input("enter grade:"))

    if avg > 100:
        print("not a legit average")
    elif avg >= 90:
        print("A")
    elif avg >=80:
        print("B")
    elif avg >=70:
        print("C")
    elif avg >=60:
        print("D")
    elif avg >=0:
        print("F")
    else:
        print("value cannot be less than 0")

#grade2()

def countVowels():
    msg = input("enter message")
    #for each character
    #test if char is a vowel - aeiou
