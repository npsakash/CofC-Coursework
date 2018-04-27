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
 * HuffmanTree.java
 * Code has been modified from Professors's Main class
 */

public class HuffmanTree implements Comparable <HuffmanTree>{

    public HuffmanNode root;
    public char characterVal;

    public HuffmanTree(HuffmanNode root){
        this.root = root;
    }

    public HuffmanNode mergeTrees(HuffmanNode leftNode, HuffmanNode rightNode){
        // ..... Left as exercise

        HuffmanNode temp = root;
        temp.right = rightNode;
        temp.left = leftNode;
        temp.weight = rightNode.weight + leftNode.weight;
        return temp;
    }


    public void printAllCodes( String code) {
        HuffmanNode node = this.root;
        if (node.weight<node.getRight().weight)

            if (node.character == '\n') {
                System.out.println("\\n " + code);

            } else if (node.character == ' ') {
                System.out.println("\\s " + code);
            } else {

                System.out.println(code);

            }

        else  {
            //traverse left
            printAllCodes(this.getCode(node.getLeft().character));

            //traverse right

            printAllCodes(this.getCode(node.getRight().character));
        }



//        if (getCode(root.character).equals('\n')){
//            System.out.println("\\n " + this.root.weight);
//        }
//        else if (getCode(root.character).equals(" ")){
//            System.out.println("\\s"+ this.root.weight);
//        }
//        if (character.equals('\n')){
//            System.out.println("\\n " + this.root.weight);
//        }
//        else if (character.equals(" ")){
//            System.out.println("\\s"+ this.root.weight);
//        }





// ..... Left as exercise
    }


    public String getCode( char character){
//        HuffmanNode node = this.root;
//
//        if((node.character == character)){
//            return code;
//        }
//        else{
//            getCode(code+"0",node.getLeft().character);
//
//            getCode(code+"1",node.getRight().character);
//            return "test";
//
//        }

        //return "test";
//
        String code = "";
        HuffmanNode node = this.root;

        while(character!=node.character){


            if (node.left.character!=character){
            code = code+"0";}
            character = node.getRight().character;
            code = code+"1";

            node = node.getRight();
        }
        return code;

//        if (character!=this.root.character){
//
//            character = root.getLeft().character;
//            code = code + "0";
//            character = root.getRight().character;
//            code = code + "1";
//            getCode(code,root.getRight().character);
//
//
//        }
//        else{
//            return code;
//
//        }
//        return code;

//        if(root.getLeft()==null&&root.getRight()==null){
//            return "?";
//        }
//        else if(character == root.character){
//            code.append("0");
//            code.append("1");
//            getCode(root.getRight(),code, character);
//            //System.out.println("test");
//            return String.valueOf(code);
//
//        }
//        else
//            return null;

    }


//    if (this.root.character == this.root.character) {
//        return "test";
//
//    }
//    else if (character == this.root.getLeft().character) {
//        return "0";
//    }
//    else if (character == this.root.getRight().character) {
//        return "1";
//    }
//    else
//
//        return null;
//    }

// Left as exercise


    public String getCharacter(char character){

// Left as exercise
        return null;
    }

    public int compareTo(HuffmanNode arg0) {
// ..... Left as exercise
        double w1 = root.weight;
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

    @Override
    public int compareTo(HuffmanTree o) {
        return 0;
    }
}
