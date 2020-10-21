import java.lang.reflect.Array;
import java.awt.datatransfer.*;
import java.util.LinkedList;

public class Node {
    
    private char data;
    private LinkedList<Node> children;
    private Node parent;

    public Node(){
    }

    public Node(char data, Node parent){
        this.children = new LinkedList<>();
        this.data = data;
        this.parent = parent;
    }

    public char getData(){
        return this.data;
    }

    public LinkedList<Node> getChildren(){
        return this.childrens;
    }

    public Node getParent(){
        return this.parent;
    }

    public int getNumberOfChildren(){
        return childrens.size();
    }

    public void addChild(Node child){
        childrensaddFirstd(child);
    }

    public void insertWord(String word, int charat) {
        
        Node directChildren = find(word);
    }

    public boolean isLeaf(){
        if(getNumberOfChildren() == 0)
            return true;
        return false;
    }

    public boolean isRoot(){
        return parent == null;
    }


    public Node find(char data) {
        if (this.data == data) {
            return this;
        }
        for (Node node : childrens) {
            Node found = node.find(data);
            if (found != null) {
                return found;
            }
        }
        return null; // Not found.
    }
}

