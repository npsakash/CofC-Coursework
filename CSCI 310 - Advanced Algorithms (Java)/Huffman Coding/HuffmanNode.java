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
 * HuffmanNode.java
 * Code has been modified from Professors's Main class
 */

public class HuffmanNode implements Comparable <HuffmanNode> {


    public double weight;
    public HuffmanNode left, right;
    public char character;

    public HuffmanNode(){
        this.weight = weight;
        this.character = character;
    }


    //add get and set for weights and characters

    public int compareTo(HuffmanNode arg0) {
        // ..... Left as exercise
        double w1 = this.weight;
        HuffmanNode comp = (HuffmanNode) arg0;
        double w2 = comp.weight;

        if(w1 > w2){
            return 1;
        }
        else if (w1 == w2){
            return 0;
        }
        else{
            return -1;
        }

    }

    public HuffmanNode getLeft() {
        return left;
    }

    public HuffmanNode getRight() {
        return right;
    }


}
