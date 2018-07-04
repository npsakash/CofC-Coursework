
public class SpeciesEqualsDemo2
{
    public static void main(String[] args)
    {
        Species s1 = new Species( ), s2 = new Species( );
        s1.setSpecies("Klingon Ox", 10, 15);
        s2.setSpecies("Klingon Ox", 10, 15);
		
        testEqualsOperator(s1, s2);
        testEqualsMethod(s1, s2);

        System.out.println("Now change one Klingon Ox to lowercase.");
        s2.setSpecies("klingon ox", 10, 15); //Use lowercase	

        testEqualsMethod(s1, s2);
    }
	
	private static void testEqualsOperator(Species s1, Species s2)
	{
        if (s1 == s2)
            System.out.println("Match with ==.");
        else
            System.out.println("Do Not match with ==.");
	}

	private static void testEqualsMethod(Species s1, Species s2)
	{
        if (s1.equals(s2))
            System.out.println("Match with the method equals.");
        else
            System.out.println("Do Not match with the method equals.");
	}
}
