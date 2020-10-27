import java.lang.reflect.Array;
import java.awt.datatransfer.*;
import java.util.LinkedList;
import java.util.Queue;

public class Node {
    
    private char data;
    private LinkedList<Node> childrens;
    private Node parent;
    private boolean endofword;

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


    public Node findChild(char data) {
        for (Node node : childrens) {
            if (node.getData() == data) {
                return node;
            }
        }
        return null;
    }


    public boolean isWord() {
        return endofword;
    }

	public void isWord(boolean b) {
        this.endofword = b;
    }
    
    public int compterMot(char[] mot, int recurrence, int compteur, StringBuilder ss, Queue<String> mots) {
        
        // vérifie si on a compléter le mot
        if (this.isWord()) {
            mots.add(ss.toString());
            recurrence = recurrence +1;
        }
            
        
        if (mot.length == compteur) {
            ss.delete(0, ss.length());
            return recurrence;
        }
            

        Node n = findChild(mot[compteur]);

        if (n == null) {
            ss.delete(0, ss.length());
            return recurrence;
        } 
        ss.append(mot[compteur]);
        return n.compterMot(mot, recurrence, compteur+1,ss,mots);


    }
}

