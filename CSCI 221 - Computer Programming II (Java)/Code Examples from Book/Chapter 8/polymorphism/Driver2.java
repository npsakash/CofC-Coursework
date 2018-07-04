public class Driver2
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
		Measurable m;
		Rectangle box = new Rectangle(5.0, 5.0);
		m = box;
		display(m);
		Circle disc = new Circle(5.0);
		m = disc;
		display(m);
	}
}