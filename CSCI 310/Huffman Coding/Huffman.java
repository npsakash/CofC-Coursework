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
 * Huffman.java
 * Code has been modified from Professors's Main class
 */

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.PriorityQueue;



public class Huffman {



    public static void compress(String textFileName) throws IOException {

        BufferedReader fileInput = new BufferedReader(new FileReader(textFileName));
        HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();

        String fileAsString = fileInput.readLine();
        //place characters and freq into Map
        int lineBreak = 0;
        while (fileAsString != null) {
            for (int i = 0; i < fileAsString.length(); i++) {
                char character = fileAsString.charAt(i);
                Integer counter = frequencyMap.get(character);
                if (counter != null) {
                    frequencyMap.put(character, counter + 1);
                } else {
                    frequencyMap.put(character, 1);
                }
            }
            lineBreak++;
            fileAsString = fileInput.readLine();

        }


        //Create Nodes
        PriorityQueueLinkedList<HuffmanTree> compressQueue = new PriorityQueueLinkedList<HuffmanTree>();
        HuffmanNode newNode = new HuffmanNode();
        HuffmanTree newTree = new HuffmanTree(newNode);

        compressQueue.PriorityEnqueue(newTree);

        //Write frequencies to file
        PrintWriter freqOutput = new PrintWriter(textFileName + "Freq.txt");
        //int fileSize = fileAsString.length();
        Iterator it = frequencyMap.entrySet().iterator();

        int spaceCount = 0;
        freqOutput.println(frequencyMap.size());
        while (it.hasNext()) {
            Map.Entry character = (Map.Entry) it.next();
            if (character.getKey().equals(' ')) {
                //System.out.println("\\s  " + character.getValue());
                spaceCount = (int) character.getValue();
            } else {
                freqOutput.println(character.getKey() + " " + character.getValue());
                //System.out.println(character.getKey() + " : " + character.getValue());
            }
            //create new node from character
            HuffmanNode charNode = new HuffmanNode();
            //assign weight and value
            charNode.weight = (int) character.getValue();
            charNode.character = (char) character.getKey();
            //add to tree
            HuffmanTree tree = new HuffmanTree(charNode);
            compressQueue.PriorityEnqueue(tree);

            it.remove();
        }
        freqOutput.println("\\n " + lineBreak);
        freqOutput.println("\\s " + spaceCount);
        freqOutput.close();


        //lowest freq are merged
        //while size of pq >1 -> dequeue then merge the dequeues into a new tree
        while (compressQueue.getData().size() >1) {
            //test queue
//            System.out.print(queue.getData().get(0).root.character);
//            System.out.println(queue.getData().get(0).root.weight);
//            queue.PriorityDequeue();
            HuffmanTree rightTree = compressQueue.PriorityDequeue();
            HuffmanTree leftTree = compressQueue.PriorityDequeue();
            HuffmanTree mergedTree = new HuffmanTree(leftTree.mergeTrees(leftTree.root,rightTree.root));
            compressQueue.PriorityEnqueue(mergedTree);


        }
        //test merge
//        System.out.println(queue.getData().get(0).root.character);
//        System.out.println(queue.getData().get(0).root.weight);
        HuffmanTree treeResult = compressQueue.PriorityDequeue();
//        System.out.println(treeResult.root.getRight().getRight().getRight().character);
//        System.out.println(treeResult.root.getRight().getRight().getRight().weight);
//        System.out.println(treeResult.root.getLeft().getLeft().character);
//        System.out.println(treeResult.root.getLeft().getLeft().weight);




        treeResult.printAllCodes("");
        //System.out.println(treeResult.toString());
        //String result = treeResult.getCode(treeResult.root,"");
        System.out.println(treeResult.getCode(treeResult.root.getRight().character));



    }







    public static void decompress(String textFileName){
        //read in freq file

    }

}
