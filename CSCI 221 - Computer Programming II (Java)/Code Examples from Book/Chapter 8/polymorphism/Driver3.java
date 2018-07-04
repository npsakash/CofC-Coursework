public class Driver3
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
		Measurable m = new Circle(5.0);
//		System.out.println(m.getCircumference()); //ILLEGAL!
		Circle c = (Circle)m;
		System.out.println(c.getCircumference()); //Legal
	}
}