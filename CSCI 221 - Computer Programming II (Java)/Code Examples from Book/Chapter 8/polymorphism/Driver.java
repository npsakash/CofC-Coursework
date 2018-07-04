public class Driver
{
	public static void display(Measurable figure)
	{
		double perimeter = figure.getPerimeter();
		double area = figure.getArea();
		System.out.println("Perimeter = " + perimeter +
						   "; area = " + area);
	}

	public static void main(String[] args)
	{
		Measurable box = new Rectangle(5.0, 5.0);
		Measurable disc = new Circle(5.0);
		display(box);
		display(disc);
	}
}