
public class ParametersDemo
{
    public static void main(String[] args)
    {
        DemoSpecies s1 = new DemoSpecies( ), 
                    s2 = new DemoSpecies( );
        s1.setSpecies("Klingon Ox", 10, 15);
        int aPopulation = 42;
        System.out.println("aPopulation BEFORE calling tryToChange: "
                           + aPopulation);
        s1.tryToChange(aPopulation);
        System.out.println("aPopulation AFTER calling tryToChange: "
                           + aPopulation);

        s2.setSpecies("Ferengie Fur Ball", 90, 56);
        System.out.println("s2 BEFORE calling tryToReplace: ");
        s2.writeOutput( );
        s1.tryToReplace(s2);
        System.out.println("s2 AFTER calling tryToReplace: ");
        s2.writeOutput( );

        s1.change(s2);
        System.out.println("s2 AFTER calling change: ");
        s2.writeOutput( );
    }
}
