/**
 * TestCompany Class
 * @author CSCI 221 HW2
 * @since Sept. 28nd 2016
 * @author <Neal Sakash>
 */
package hw2.csci221;

/**
 *
 * @author Neal
 */
public class TestCompany {
    public static void main(String[] args)
    {
        Company firstCompany = new Company("ambassador", 2001, 10000, 'D');
        String description = firstCompany.getDescription();
        System.out.println(description);
    
        
    }
            
    
}
