Python 3.5.1 (v3.5.1:37a07cee5969, Dec  6 2015, 01:38:48) [MSC v.1900 32 bit (Intel)] on win32
Type "copyright", "credits" or "license()" for more information.
>>> def examples():
	name=input("Enter your name")
	print("Hello", name)

	
>>> examples()
Enter your nameNeal
Hello Neal
>>> def cupConverter():
	print("Converts cups into ounces and milliliters")
	print()
	CUPS_TO_OZ = 8
	OZ_TO_ML = 29.57
	#Get number of cups
	cups=eval(input("Enter number of cups:"))
	#Calculate number of ounces
	ounces = cups * CUPS_TO_OZ

	
>>> cupConverter()
Converts cups into ounces and milliliters

Enter number of cups:9
>>> def cupConverter():
	print("Converts cups into ounces and milliliters")
	print()
	CUPS_TO_OZ = 8
	OZ_TO_ML = 29.57
	#Get number of cups
	cups=eval(input("Enter number of cups:"))
	#Calculate number of ounces
	ounces = cups * CUPS_TO_OZ
	#Convert to milliliters
	milliliters = ounces * OZ_TO_ML
	#Display output
	print(cups, "cups", ounces, "oz", milliliters, "mL")

	
>>> cupConverter()
Converts cups into ounces and milliliters

Enter number of cups:9
9 cups 72 oz 2129.04 mL
>>> def cupConverter():
	print("Converts cups into ounces and milliliters")
	print()
	CUPS_TO_OZ = 8
	OZ_TO_ML = 29.57
	#Get number of cups
	#loop
	numConv=eval(input("Number of conversions?"))
	for i in range(numConv)
	cups=eval(input("Enter number of cups:"))
	#Calculate number of ounces
	ounces = cups * CUPS_TO_OZ
	#Convert to milliliters
	milliliters = ounces * OZ_TO_ML
	#Display output
	print(cups, "cups=", ounces, "oz", milliliters, "mL")
	
SyntaxError: invalid syntax
>>> 
>>> 
[DEBUG ON]
>>> 
[DEBUG OFF]
>>> def cupConverter():
	print("Converts cups into ounces and milliliters")
	print()
	CUPS_TO_OZ = 8
	OZ_TO_ML = 29.57
	#Get number of cups
	#loop
	numConv=eval(input("Number of conversions?"))
	for i in range(numConv)
	cups=eval(input("Enter number of cups:"))
	#Calculate number of ounces
	ounces = cups * CUPS_TO_OZ
	#Convert to milliliters
	milliliters = ounces * OZ_TO_ML
	#Display output
	print(cups, "cups=", ounces, "oz", milliliters, "mL")
	
SyntaxError: invalid syntax
>>> 
>>> 
>>> 
