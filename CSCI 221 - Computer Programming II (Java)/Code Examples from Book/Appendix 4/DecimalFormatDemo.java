
import java.text.DecimalFormat;

public class DecimalFormatDemo
{
    public static void main(String[] args)
    {
        DecimalFormat twoDigitsPastPoint = new DecimalFormat("0.00");
        DecimalFormat threeDigitsPastPoint = 
                            new DecimalFormat("00.000");

        double d = 12.3456789;
        System.out.println(twoDigitsPastPoint.format(d));
        System.out.println(threeDigitsPastPoint.format(d));

        double money = 12.8;
        System.out.println("$" + twoDigitsPastPoint.format(money));
        String numberString = twoDigitsPastPoint.format(money);
        System.out.println(numberString);

        DecimalFormat percent = new DecimalFormat("0.00%");

        double fraction = 0.734;
        System.out.println(percent.format(fraction));

        //1 or 2 digits before decimal point:
		DecimalFormat eNotation1 = new DecimalFormat("#0.###E0");
        //2 digits before decimal point:
	    DecimalFormat eNotation2 = new DecimalFormat("00.###E0");

        double number = 123.456;
        System.out.println(eNotation1.format(number));
        System.out.println(eNotation2.format(number));

        double small = 0.0000123456;
        System.out.println(eNotation1.format(small));
        System.out.println(eNotation2.format(small));
    }
}
