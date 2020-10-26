import java.util.LinkedList;


public class Tree {
   private Node root;

   // Default constructor
   public Tree() {
      this.root = new Node('1', null);
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

      char firstChar = word.charAt(0);
      //cherche si un enfant contient le first char et retourne le node(null si ne trouve pas de noeud)
      Node firstNode = root.find(firstChar);

      if(firstNode == null){
         System.out.println(firstChar+ "nest pas encore dans l'arbre a ce niveau");
         firstNode = new Node(firstChar,root);
         root.addChild(firstNode);
      }

      Node previousNode = firstNode;
      Node myNode = new Node(' ',null);

      for (int i = 1; i < word.length(); i++) { 
         myWord[i] = word.charAt(i);

         //si le charactere n'est pas un enfant de previous node 
         if(previousNode.find(myWord[i]) == null){
            System.out.println(myWord[i]+ "nest pas encore dans l'arbre a ce niveau");

            myNode = new Node(myWord[i], previousNode);
            previousNode.addChild(myNode);
         }

         System.out.print(myWord[i]+" ");
         previousNode = myNode;
     }

     System.out.println(myWord.toString());
   }

}
