import java.util.LinkedList;

public class Tree {
   private Node root;

   // Default constructor
   public Tree() {
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
      for (Node data : element.getChildren()) {
         walk(data, list);
      }
   }

   public Node find(char data) {
      return root == null ? null : root.find(data);
   }

   public void insertWord(String word) {
      Node found = find(parentData);
      found.insertWord(word, 0);

   }

 
   public boolean insert(char parentData, char data) {
      Node found = find(parentData);
      if (found == null) {
         return false;
      }
      found.getChildren().add(new Node(data, found));
      return true;
   }

}
