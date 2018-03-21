
package HW5;

/**
 * @author Neal Sakash
 * @since November 3, 2016
 * @version 1
 * HW 5 - CSCI 221 Fall 2016
 * Used to test implemented inheritance methods in the Person, Employee,
 * Faculty, and Staff classes.
 */

public class TestPerson {
    /**
     * 
     * @param args 
     */
    public static void main(String[] args){
        // 1-6
        Person person1 = new Person("Sam Spade");
        Faculty faculty1 = new Faculty("Sebastian Van Delden", 11000, "Computer Science Department");
        Faculty faculty2 = new Faculty("Sebastian Van Delden", 23000, "Sociology Department");
        Faculty faculty3 = new Faculty("Vince Lombardi", 90000, "Sociology Department");
        Faculty faculty4 = new Faculty("Vince Lombardi", 90000, "Sociology Department");
        Staff staff1 = new Staff("Marilee Smith", 11111, 4);
        
        // 7
        person1.display();
        faculty1.display();
        faculty2.display();
        faculty3.display();
        faculty4.display();
        staff1.display();
        
        // 8-11
        faculty2.equals(faculty3);
        faculty3.equals(faculty4);
        //faculty3 == faculty4;
        person1.equals(faculty1);
        person1.equals(staff1);
    
    }   //  end main() method
}   //  end TestPerson class definition
