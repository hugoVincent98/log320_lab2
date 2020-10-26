import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.CacheResponse;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;




public class MotCroise {

    String grilleFile;
    String dictFile;
    char[][] grilleCharactere;
    Tree dictionnaire;
    int n;

    public MotCroise(String grilleFile, String dictFile){
        this.grilleFile = grilleFile;
        this.dictFile = dictFile;
        dictionnaire = new Tree();
    }

    public void analyse(){


        //mettre le fichier grille dans un tableau de char
        try {
            File myObj = new File(grilleFile);
            Scanner myReader = new Scanner(myObj);

            //permet de sortir la grosseur de la grille et la met en int 
            String num = myReader.nextLine();
            n = Integer.parseInt(num);

            grilleCharactere = new char[n][n];

            //j la ligne analyse
            int i = 0;
            //permet de passer sur chaque ligne de la grille et de cree un tableau de char qui sera plus facile a travaille avec
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                for (int j = 0; j < n; j++) { 
                    grilleCharactere[i][j] = data.charAt(j);
                }
                i++;
            }
            myReader.close();

            /*for (i = 0; i < n; i++) { 
                for (int j = 0; j < n; j++) { 
                    System.out.print(grilleCharactere[i][j] + " "); 
                }
                System.out.println();
            }*/

        }catch (FileNotFoundException e) {
            System.out.println("Un probleme est survenu");
            e.printStackTrace();
        }



        //mettre le fichier dictionnaire dans un tableau de char
        try {
            File myObj = new File(dictFile);
            Scanner myReader = new Scanner(myObj);
            System.out.println("-------debut de larbre------");

            //permet de passer sur chaque ligne de la grille et de cree un tableau de char qui sera plus facile a travaille avec
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dictionnaire.insertWord(data);
            }
            myReader.close();


            LinkedList<Node> treelist = dictionnaire.toList();
            this.LevelOrderTraversal(treelist.getFirst());



        }catch (FileNotFoundException e) {
            System.out.println("Un probleme est survenu");
            e.printStackTrace();
        }






        //TODO creer un arbre pour etre capable de reconnaitre des mots

        
    }    
    






    static void LevelOrderTraversal(Node root) { 
    if (root == null) 
        return; 
  
    // Standard level order traversal code 
    // using queue 
    Queue<Node > q = new LinkedList<>(); // Create a queue 
    q.add(root); // Enqueue root  
    while (!q.isEmpty()) 
    { 
        int n = q.size(); 
  
        // If this node has children 
        while (n > 0) 
        { 
            // Dequeue an item from queue 
            // and print it 
            Node p = q.peek(); 
            q.remove(); 
            System.out.print(p.getData() + " "); 
  
            // Enqueue all children of  
            // the dequeued item 
            for (int i = 0; i < p.getChildrens().size(); i++){
                q.add(p.getChildrens().get(i)); 

            }
            n--;
        } 
          
        // Print new line between two levels 
        System.out.println();  
    } 
} 

}
