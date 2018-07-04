// CSCI 310 Advanced Algorithms
// Sebastian van Delden
//
// Skeleton Code for Huffman Coding
//
/**
 * @author Neal Sakash
 * @since December 3, 2017
 * @version 1
 * HW 1 - CSCI 310 Fall 2017
 * Main.java
 * Code has been modified from Professors's Main class
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {


    public static void main(String[] args){
        //Files
        String smallFile = "C:\\Users\\Neal\\Documents\\CofC\\2017\\Fall\\CSCI 310\\AssignmentTwo\\src\\small.txt";
        String mediumFile = "C:\\Users\\Neal\\Documents\\CofC\\2017\\Fall\\CSCI 310\\AssignmentTwo\\src\\medium.txt";
        String largeFile = "C:\\Users\\Neal\\Documents\\CofC\\2017\\Fall\\CSCI 310\\AssignmentTwo\\src\\large.txt";


        try {
            Huffman.compress(smallFile);
            Huffman.compress(mediumFile);
            Huffman.compress(largeFile);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
