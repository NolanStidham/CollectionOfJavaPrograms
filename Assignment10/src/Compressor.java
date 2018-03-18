
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * COSC2203-01 Data Structures Assignment Number: 10 Author(s): Nolan Stidham
 * Date of Last Modification: 11/2/2017 Description: (inputs, outputs,
 * processes...) This program takes line(s) of strings and converts them to
 * binary representation for data compression, sending the output to the console
 */
public class Compressor {

    public static void main(String[] args) throws FileNotFoundException {
        //Data Fields
        //Table File:
        String fileName = args[0];
        Scanner inputFile = new Scanner(new File(fileName));
        ArrayList<TableItem> table = new ArrayList<>();
        //Setting up the decoding tree
        ArrayList<BinaryTree> listOfTrees = new ArrayList<>();
        
        //Add the trees
        listOfTrees.add(new BinaryTree("j", null, null));
        listOfTrees.add(new BinaryTree("k", null, null));
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(0), listOfTrees.get(1)));
        listOfTrees.remove(0);
        listOfTrees.remove(0);
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(0), new BinaryTree("v", null, null)));
        listOfTrees.remove(0);
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(0), new BinaryTree("m", null, null)));
        listOfTrees.remove(0);
        //Add subtree which contains g, b
        listOfTrees.add(new BinaryTree("g", null, null));//In index 1
        listOfTrees.add(new BinaryTree("b", null, null));//In index 2
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(1), listOfTrees.get(2)));//In index 3
        listOfTrees.remove(1);//Remove g
        listOfTrees.remove(1);//Remove b
        //Now the subtree is in index 1
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(0), listOfTrees.get(1)));//Add g-b to the main tree, In index 2
        listOfTrees.remove(0);//Main tree in index 1
        listOfTrees.remove(0);//Main tree in index 0
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(0), new BinaryTree("n", null, null)));
        listOfTrees.remove(0);
        //Add subtree which contains u, l, t
        //Add subtree which contains u, l
        listOfTrees.add(new BinaryTree("u", null, null));//In index 1
        listOfTrees.add(new BinaryTree("l", null, null));//In index 2
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(1), listOfTrees.get(2)));//In index 3
        listOfTrees.remove(1);//Remove u, now in index 2
        listOfTrees.remove(1);//Remove l now in index 1
        //Add u,l to t
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(1), new BinaryTree("t", null, null)));//In index 2
        listOfTrees.remove(1);//Now in index 1
        //Add u, l, t to main tree
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(0), listOfTrees.get(1)));//In index 2
        listOfTrees.remove(0);//Now index 1
        listOfTrees.remove(0);//Now index 0
        
        //Add subtree which contains p,c,f,d,o,"space"
        //Add subtree which contains p,c
        listOfTrees.add(new BinaryTree("p", null, null));//index 1
        listOfTrees.add(new BinaryTree("c", null, null));//index 2
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(1), listOfTrees.get(2)));//Index 3
        listOfTrees.remove(1);//Now 2
        listOfTrees.remove(1);//Now 1
        //Add f to the subtree
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(1), new BinaryTree("f", null, null)));//Index 2
        listOfTrees.remove(1);//Now 1
        //Add d to the subtree
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(1), new BinaryTree("d", null, null)));//Index 2
        listOfTrees.remove(1);//Now 1
        //Add o to the subtree
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(1), new BinaryTree("o", null, null)));//Index 2
        listOfTrees.remove(1);//Now 1
        //Add "space" to the subtree
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(1), new BinaryTree(" ", null, null)));//Index 2
        listOfTrees.remove(1);//Now 1
        //Add subtree to main tree
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(0), listOfTrees.get(1)));//In index 2
        listOfTrees.remove(0);//Now index 1
        listOfTrees.remove(0);//Now index 0
        //Add subtree which contains y, w, i, h, r, u, s, e
        //Add subtree which contains y,w
        listOfTrees.add(new BinaryTree("y", null, null));//index 1
        listOfTrees.add(new BinaryTree("w", null, null));//index 2
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(1), listOfTrees.get(2)));//Index 3
        listOfTrees.remove(1);//Now 2
        listOfTrees.remove(1);//Now 1
        //Add i to the subtree
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(1), new BinaryTree("i", null, null)));//Index 2
        listOfTrees.remove(1);//Now 1
        //Add subtree h,r
        listOfTrees.add(new BinaryTree("h", null, null));//index 2
        listOfTrees.add(new BinaryTree("r", null, null));//index 3
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(2), listOfTrees.get(3)));//Index 4
        listOfTrees.remove(2);//Now 3
        listOfTrees.remove(2);//Now 2
        //Add h,r to subtree y,w,i
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(1), listOfTrees.get(2)));//In index 3
        listOfTrees.remove(0);//Now index 2
        listOfTrees.remove(0);//Now index 1
        //Add subtree u,s,e
        //Add subtree which contains u,s
        listOfTrees.add(new BinaryTree("u", null, null));//index 2
        listOfTrees.add(new BinaryTree("s", null, null));//index 3
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(2), listOfTrees.get(3)));//Index 4
        listOfTrees.remove(1);//Now 3
        listOfTrees.remove(1);//Now 2
        //Add e to the subtree
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(2), new BinaryTree("e", null, null)));//Index 3
        listOfTrees.remove(1);//Now 2
        //Add u,s,e to subtree y,w,i,h,r
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(1), listOfTrees.get(2)));//In index 3
        listOfTrees.remove(1);//Now index 2
        listOfTrees.remove(1);//Now index 1
        //Add subtree y,w,i,h,r,u,s,e to the main tree
        listOfTrees.add(new BinaryTree("*", listOfTrees.get(0), listOfTrees.get(1)));//In index 2
        listOfTrees.remove(0);//Now in index 1
        listOfTrees.remove(0);//Now in index 0
        
        //The finished tree
        BinaryTree huffmanTree = listOfTrees.get(0);
        
        System.out.println(huffmanTree.toString());
        
        
        //Set up table ArrayList
        while (inputFile.hasNext()) {
            String character = inputFile.next();
            String binaryCode = inputFile.next();

            table.add(new TableItem(character, binaryCode));
        }//end of while

        //*/
    }//End of Main

}//End of Compressor

class TableItem {

    //Data Fields 
    private String character;
    private String binaryCode;

    //Constructor
    public TableItem(String character, String binaryCode) {
        this.character = character;
        this.binaryCode = binaryCode;
    }

    public String getBinaryCode() {
        return binaryCode;
    }

    public String getCharacter() {
        return character;
    }

    public void setBinaryCode(String binaryCode) {
        this.binaryCode = binaryCode;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}//End of TableItem

class BinaryTree<E> implements Serializable {
    //Data fields
    protected Node<E> root;
    
    //Constructor

    public BinaryTree() {
    }

    public BinaryTree(Node<E> root) {
        this.root = root;
    }
    
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
        root = new Node<>(data);
        if(leftTree != null){
            root.left = leftTree.root;
        }//end of if
        else
            root.left = null;
        
        if(rightTree != null){
            root.right = rightTree.root;
        }//end of if
        else
            root.right = null;  
    }//end of constructor
    
    //Methods
    public BinaryTree<E> getLeftSubtree(){
        if(root != null && root.left != null)
            return new BinaryTree<>(root.left);
        else
            return null;
    }//end of getLeftSubtree
    
    public BinaryTree<E> getRightSubtree(){
        if(root != null && root.right != null)
            return new BinaryTree<>(root.right);
        else
            return null;
    }//end of getRightSubtree
    
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }//end of isLeaf()
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        toString(root, 1, sb);
        return sb.toString();
    }//end of toString
    
    private void toString(Node<E> node, int depth, StringBuilder sb){
        for (int i = 1; i < depth; i++) {
            sb.append(" ");
        }
        
        if(node == null){
            sb.append("null\n");
        } else{
            sb.append(node.toString());
            sb.append("\n");
            toString(node.left, depth + 1, sb);
            toString(node.right, depth + 1, sb);
        }
    }//end of toString
    

    protected static class Node<E> implements Serializable {
        //Data Fields
        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        //Constructors
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }//end of constructor

        //Methods
        @Override
        public String toString() {
            return data.toString();
        }//end of toString
    }//End of Node<E>
}//End of BinaryTree

