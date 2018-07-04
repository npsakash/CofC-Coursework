
public class PurchaseDemo
{
    public static void main(String[] args)
    {
        Purchase oneSale = new Purchase( );
        oneSale.readInput( );
        oneSale.writeOutput( );
        System.out.println("Cost each $" + oneSale.getUnitCost( ));
        System.out.println("Total cost $" + oneSale.getTotalCost( ));
    }
}
