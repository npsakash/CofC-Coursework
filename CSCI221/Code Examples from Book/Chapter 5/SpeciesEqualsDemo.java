
public class SpeciesEqualsDemo
{
    public static void main(String[] args)
    {
        Species s1 = new Species( ), s2 = new Species( );
        s1.setSpecies("Klingon ox", 10, 15);
        s2.setSpecies("Klingon ox", 10, 15);
		
        if (s1 == s2)
            System.out.println("Match with ==.");
        else
            System.out.println("Do Not match with ==.");
			
        if (s1.equals(s2))
            System.out.println("Match with the method equals.");
        else
            System.out.println("Do Not match with the method equals.");
			
        System.out.println("Now change one Klingon ox to lowercase.");
        s2.setSpecies("klingon ox", 10, 15); //Use lowercase
		
        if (s1.equals(s2))
            System.out.println("Match with the method equals.");
        else
            System.out.println("Do Not match with the method equals.");
    }
}
