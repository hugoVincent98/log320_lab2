import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Tree {
   private Node root;

   // Default constructor
   public Tree() {
      this.root = new Node('0', null);
   }

   // Returns the root
   public Node getRoot() {
      return this.root;
   }

   // Returns the Tree<T> as a List of Node<T> objects
   public LinkedList<Node> toList() {
      LinkedList<Node> list = new LinkedList<Node>();
      walk(root, list);
      return list;
   }

   // String representation of tree
   public String toString() {
      return toList().toString();
   }

   // Preorder traversal
   private void walk(Node element, LinkedList<Node> list) {
      list.add(element);
      for (Node data : element.getChildrens()) {
         walk(data, list);
      }
   }

   public Node find(char data) {
      return root == null ? null : root.findChild(data);
   }
 
   public boolean insert(char parentData, char data) {
      Node found = find(parentData);
      if (found == null) {
         return false;
      }
      found.getChildrens().add(new Node(data, found));
      return true;
   }

   //Permet dinserer un mot dans l'arbre
   public void insertWord(String word){
      char[] myWord = new char[word.length()];
      //System.out.println("the word is: "+ word);

      char firstChar = word.charAt(0);
      //cherche si un enfant contient le first char et retourne le node(null si ne trouve pas de noeud)
      Node firstNode = root.findChild(firstChar);

      if(firstNode == null){
         //System.out.println(firstChar+ " n'est pas encore dans le premier niveau");
         firstNode = new Node(firstChar,root);
         root.addChild(firstNode);
      }

      Node previousNode = firstNode;
      Node myNode = new Node(' ',null);

      for (int i = 1; i < word.length(); i++) { 
         myWord[i] = word.charAt(i);

         //si le charactere n'est pas un enfant de previous node 
         if(previousNode.findChild(myWord[i]) == null || myWord[i-1] == myWord[i]){
            //System.out.println(myWord[i]+" added");

            myNode = new Node(myWord[i], previousNode);
            previousNode.addChild(myNode);

         }else if(previousNode.findChild(myWord[i]) != null){
            //System.out.println(myWord[i]+" already there");
            myNode = previousNode.findChild(myWord[i]);
         }
         previousNode = myNode;
     }
     previousNode.isWord(true);
    
    
   }

   public int compterMot(char[] mot, Queue<String> mots) {
      
      return root.compterMot(mot, 0,0,new StringBuilder(), mots);
   }

}
