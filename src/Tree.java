import java.util.LinkedList;


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
      return root == null ? null : root.find(data);
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
      System.out.println("the word is: "+ word);

      char firstChar = word.charAt(0);
      //cherche si un enfant contient le first char et retourne le node(null si ne trouve pas de noeud)
      Node firstNode = root.find(firstChar);

      if(firstNode == null){
         System.out.println(firstChar+ " n'est pas encore dans le premier niveau");
         firstNode = new Node(firstChar,root);
         root.addChild(firstNode);
      }

      Node previousNode = firstNode;
      Node myNode = new Node(' ',null);

      for (int i = 1; i < word.length(); i++) { 
         myWord[i] = word.charAt(i);

         //si le charactere n'est pas un enfant de previous node 
         if(previousNode.find(myWord[i]) == null || myWord[i-1] == myWord[i]){
            System.out.println(myWord[i]+" added");

            myNode = new Node(myWord[i], previousNode);
            previousNode.addChild(myNode);

         }else if(previousNode.find(myWord[i]) != null){
            System.out.println(myWord[i]+" already there");
            myNode = previousNode.find(myWord[i]);
         }
         previousNode = myNode;
     }

     previousNode.addChild(new Node('1', previousNode));
     System.out.println("1 added at the end");
   }

}
