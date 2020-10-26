import java.lang.reflect.Array;
import java.awt.datatransfer.*;
import java.util.LinkedList;

public class Node {
    
    private char data;
    private LinkedList<Node> childrens;
    private Node parent;

    public Node(){
    }

    public Node(char data, Node parent){
        this.childrens = new LinkedList<>();
        this.data = data;
        this.parent = parent;
    }

    public char getData(){
        return this.data;
    }

    public LinkedList<Node> getChildrens(){
        return this.childrens;
    }

    public Node getParent(){
        return this.parent;
    }

    public boolean addChild(Node child){

        for(int i=0; i<this.childrens.size(); i++){

            if(this.childrens.get(i).getData() == child.getData()){
                return false;
            }
        }

        this.childrens.add(child);
        return true;
    }

    public boolean isLeaf(){
        if(this.childrens.size() == 0)
            return true;
        return false;
    }

    public boolean isRoot(){
        return parent == null;
    }


    public Node find(char data) {
        for (Node node : childrens) {
            if (node.getData() == data) {
                return node;
            }
        }
        return null;
    }
}

