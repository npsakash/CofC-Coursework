/*2.9: A Silly Sentence

Write a program  that asks the user to enter a favorite color,
a favorite food, a favorite animal, and the first name  of a
friend or relative. The program  should then print the following two
lines, with the user’s input replacing the items in italics:

I had a dream that   href="asfunction:_root.doTutor,7,JAVA">NAME  ate a COLOR  ANIMAL  and said it tasted like FOOD!

  For example, if the user entered blue  for the color, hamburger  for the food, dog  for the animal, and Jake  for the person’s name , the output  would be:

I had a dream that Jake ate a blue dog and said it tasted like hamburger!

Don’t forget to put the exclamation mark at the end.*/

import java.util.Scanner;

public class SillySentence
{
	public static void main(String[] args)
	{
		//System.out.println("This program will generate a silly sentence from your responses");

		Scanner keyboard = new Scanner(System.in);

		String color, food, animal, name;
		
		System.out.println("Enter the name of someone you know:");
		name = keyboard.nextLine();

		System.out.println("Enter your favorite color:");
		color = keyboard.nextLine();

		System.out.println("Enter your favorite food:");
		food = keyboard.nextLine();

		System.out.println("Enter your favorite animal:");
		animal = keyboard.nextLine();

		System.out.println("I had a dream that " + name + " ate a " + color + " " + animal + " and said it tasted like " + food + "!");
	}

}