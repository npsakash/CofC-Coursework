/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cofc.cs.csci230;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author matt
 */
public class HashTesting {//TODO convert this class to work only with values and not keys

    final static int FILE_SIZE = 1000;//the number of elements contained in the files handled by this class

    public static void main(String[] args) throws FileNotFoundException, FullHashTableException, ElementNotInHashTableException {
        PrintWriter output = new PrintWriter(new File("file.txt"));
        
        for (int elementsInHash = 5; elementsInHash <= FILE_SIZE; elementsInHash++){ //This loop starts with one element in the hash and gradually increases 
            OpenHashing oh;
            ClosedHashing ch;
            InputStream inStream1;
            
            Scanner scan;
            int[] tenDigitKeyList;
            int[] elevenDigitKeyList;

            inStream1 = HashTesting.class.getResourceAsStream("randomStrings.txt");
            scan = new Scanner(inStream1);
            
            oh = new OpenHashing<>(FILE_SIZE);
            ch = new ClosedHashing<>(FILE_SIZE);
            tenDigitKeyList = new int[elementsInHash];

            for (int i = 0; i < elementsInHash; i++) {//Loads the hashes with the same set of data 
                String s = scan.next();
                tenDigitKeyList[i] = s.hashCode();
                oh.insert(s);
                ch.insert(s);
            }

            scan.close();

            elevenDigitKeyList = new int[elementsInHash];
            scan = new Scanner(HashTesting.class.getResourceAsStream("random11DigitStrings.txt"));
            for (int i = 0; i < elementsInHash; i++) {//
                String temp = scan.next();
                elevenDigitKeyList[i] = temp.hashCode();
            }

            long ohSuccessfulSearchTime = 0;
            long chSuccessfulSearchTime = 0;
            long ohUnsuccessfulSearchTime = 0;
            long chUnsuccessfulSearchTime = 0;
            long startTime;

            startTime = System.nanoTime();
            for (int k : tenDigitKeyList) {
                oh.search(k);
            }
            ohSuccessfulSearchTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            for (int k : tenDigitKeyList) {

                ch.contains(k);
                //chSuccessfulSearchTime.add(startTime-System.currentTimeMillis());
            }
            chSuccessfulSearchTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            for (int k : elevenDigitKeyList) {
                oh.contains(k);
                //ohUnsuccessfulSearchTime.add(startTime-System.currentTimeMillis());
            }
            ohUnsuccessfulSearchTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            for (int k : elevenDigitKeyList) {

                ch.contains(k);
                //System.out.println(startTime-System.currentTimeMillis());
                //chUnsuccessfulSearchTime.add(startTime-System.currentTimeMillis());
            }
            chUnsuccessfulSearchTime = System.nanoTime() - startTime;
            System.out.println(elementsInHash);
            System.out.println(ohSuccessfulSearchTime);
            System.out.println(chSuccessfulSearchTime);
            System.out.println(ohUnsuccessfulSearchTime);
            System.out.println(chUnsuccessfulSearchTime);
            System.out.println();
            
            output.println(elementsInHash + "\t" + ohSuccessfulSearchTime/(double)elementsInHash + "\t" 
                    + chSuccessfulSearchTime/(double)elementsInHash + "\t" + ohUnsuccessfulSearchTime/(double)elementsInHash +
                    "\t" + chUnsuccessfulSearchTime/(double)elementsInHash );
            output.flush();
        }
        

    }

}