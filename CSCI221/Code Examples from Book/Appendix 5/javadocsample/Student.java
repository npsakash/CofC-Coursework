
package javadocsample;


/**
 class for a student with a name and a student number.
*/
public class Student extends Person
{
    private int studentNumber;

    public Student( )
    {
        super( );
        studentNumber = 0;//Indicating no number yet
    }

    /**
     @param initialName student name
     @param initialStudentNumber student number
    */
    public Student(String initialName, int initialStudentNumber)
    {
        super(initialName);
        studentNumber = initialStudentNumber;
    }

    /**
     Resets student name and number.
    */
    public void reset(String newName, int newStudentNumber)
    {
        setName(newName);
        studentNumber = newStudentNumber;
    }

    /**
     @return student number
    */
    public int getStudentNumber( )
    {
        return studentNumber;
    }

    /**
     Sets student number.
    */
    public void setStudentNumber(int newStudentNumber)
    {
        studentNumber = newStudentNumber;
    }

    public void writeOutput( )
    {
        System.out.println("Name: " + getName( ));
        System.out.println("Student Number: " + studentNumber);
    }

    /**
     @param otherStudent the Student object being compared to the calling object.
     @return true if calling object and otherStudent have the same name and the same student number.
    */
    public boolean equals(Student otherStudent)
    {
        return (this.sameName(otherStudent)
             && (this.studentNumber == otherStudent.studentNumber));
    }

    public String toString( )
	{
	    return("Name: " + getName( )
	                    + "\nStudent number: "
	                    + studentNumber);
    }
}
