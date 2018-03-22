import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class TransactionReader
{
    public static void main(String[] args)
    {
        String fileName = "Transactions.txt";
        try
        {
            Scanner inputStream = new Scanner(new File(fileName));
            // Read the header line
            String line = inputStream.nextLine();
			// Total sales
            double total = 0;
            // Read the rest of the file line by line
            while (inputStream.hasNextLine())
            {
				// Contains SKU,Quantity,Price,Description
				line = inputStream.nextLine();
				// Turn the string into an array of strings
				String[] ary = line.split(",");
				// Extract each item
				String SKU = ary[0];
				int quantity = Integer.parseInt(ary[1]);
				double price = Double.parseDouble(ary[2]);
				String description = ary[3];
				// Output item
				System.out.printf("Sold %d of %s (SKU: %s) at $%1.2f each.\n",
					quantity, description, SKU, price);
				// Compute total
				total += quantity * price;
			}
			System.out.printf("Total sales: $%1.2f\n",total);
            inputStream.close( );
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Cannot find file " + fileName);
        }
        catch(IOException e)
        {
            System.out.println("Problem with input from file " + fileName);
        }
    }
}