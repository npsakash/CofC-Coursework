import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileOrganizer extends JFrame implements ActionListener
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    public static final int NUMBER_OF_CHAR = 30;
    private JTextField fileNameField;
    private JTextField firstLineField;
	
    public FileOrganizer( )
    {
        setSize(WIDTH, HEIGHT);
        WindowDestroyer listener = new WindowDestroyer( );
        addWindowListener(listener);
		
        Container contentPane = getContentPane( );
        contentPane.setLayout(new FlowLayout( ));
		
        JButton showButton = new JButton("Show first line");
        showButton.addActionListener(this);
        contentPane.add(showButton);
		
        JButton removeButton = new JButton("Remove file");
        removeButton.addActionListener(this);
        contentPane.add(removeButton);
		
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        contentPane.add(resetButton);
		
        fileNameField = new JTextField(NUMBER_OF_CHAR);
        contentPane.add(fileNameField);
		
        fileNameField.setText("Enter file name here.");
        firstLineField = new JTextField(NUMBER_OF_CHAR);
        contentPane.add(firstLineField);
    }
	
    public void actionPerformed(ActionEvent e)
    {
		String actionCommand = e.getActionCommand( );
		if (actionCommand.equals("Show first line"))
		    showFirstLine( );
		else if (actionCommand.equals("Remove file"))
		    removeFile( );
		else if (actionCommand.equals("Reset"))
		    resetFields();
		else
		    firstLineField.setText("Unexpected error.");
    }
	
    private void showFirstLine( )
    {
        Scanner fileInput = null;
        String fileName = fileNameField.getText( );
        File fileObject = new File(fileName);
		
        if (!fileObject.exists( ))
            firstLineField.setText("No such file");
        else if (!fileObject.canRead( ))
            firstLineField.setText("That file is not readable.");
        else
        {
            try
            {
                fileInput = new Scanner(fileObject);
            }
            catch(FileNotFoundException e)
            {
                firstLineField.setText("Error opening the file " +
                                        fileName);
            }
            String firstLine = fileInput.nextLine( );
            firstLineField.setText(firstLine);
            fileInput.close( );
        }
    }
	
    private void resetFields()
    {
        fileNameField.setText("Enter file name here.");
        firstLineField.setText("");
    }
	
    private void removeFile( )
    {
        Scanner fileInput = null;
        String firstLine;
        String fileName = fileNameField.getText( );
        File fileObject = new File(fileName);
		
        if (!fileObject.exists( ))
            firstLineField.setText("No such file");
        else if (!fileObject.canWrite( ))
            firstLineField.setText("Permission denied.");
        else
        {
            if (fileObject.delete( ))
                firstLineField.setText("File deleted.");
            else
                firstLineField.setText("Could not delete file.");
        }
    }
	
    public static void main(String[] args)
    {
        FileOrganizer gui = new FileOrganizer( );
        gui.setVisible(true);
    }
}
	