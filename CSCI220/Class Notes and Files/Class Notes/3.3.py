def main():
    n = eval(input("Number:"))
    fact = 1
    for factor in range(n,1,-1):
        fact = fact*factor
    print(n,"is",fact)

main()
