import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.CacheResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;




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


        }catch (FileNotFoundException e) {
            System.out.println(String.format("Le fichier %0 n'a pas été trouvé", grilleFile));
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

        }catch (FileNotFoundException e) {
            System.out.println(String.format("Le fichier %0 n'a pas été trouvé", dictFile));
            e.printStackTrace();
        }

        // debut algorithme

        trouverMot();
        

        
    }    
    

    public void trouverMot(){

        Queue<String> mots = new PriorityQueue<>();
        int compteur = 0;
        for(int i = 0; i < n ; i++){
            for (int j = 0; j < n ; j++){  // pour chaque char
             
            char maLettre = grilleCharactere[i][j];

            // lire de gauche a droite
            char[] maListeChar = new char[n-j];
            for(int k = 0 ; k < maListeChar.length ; k++){
                maListeChar[k] = grilleCharactere[i][j+k];
            }
            compteur += dictionnaire.compterMot(maListeChar,mots);

            //lire de droite a gauche
            maListeChar = new char[j+1];
            for(int k = 0 ; k < maListeChar.length ; k++){
                maListeChar[k] = grilleCharactere[i][j-k];
            }
            compteur += dictionnaire.compterMot(maListeChar,mots);

            // lire haut en bas
            maListeChar = new char[n-i];
            for(int k = 0 ; k < maListeChar.length ; k++){
                maListeChar[k] = grilleCharactere[i+k][j];
            }
            compteur += dictionnaire.compterMot(maListeChar,mots);

            //lire de bas en haut
            maListeChar = new char[i+1];
            for(int k = 0 ; k < maListeChar.length ; k++){
                maListeChar[k] = grilleCharactere[i-k][j];
            }
            compteur += dictionnaire.compterMot(maListeChar,mots);

            // lire ↗
            maListeChar = new char[Math.min(i+1,n-j)];
            for(int k = 0 ; k < maListeChar.length ; k++){
                maListeChar[k] = grilleCharactere[i-k][j+k];
            }
            compteur += dictionnaire.compterMot(maListeChar,mots);
            
            // lire ↘
            maListeChar = new char[Math.min(n-i,n-j)];
            for(int k = 0 ; k < maListeChar.length ; k++){
                maListeChar[k] = grilleCharactere[i+k][j+k];
            }
            compteur += dictionnaire.compterMot(maListeChar,mots);



            // lire ↖       
            maListeChar = new char[Math.min(i+1,j+1)];
            for(int k = 0 ; k < maListeChar.length ; k++){
                maListeChar[k] = grilleCharactere[i-k][j-k];
            }
            compteur += dictionnaire.compterMot(maListeChar,mots);


            // lire ↙
            maListeChar = new char[Math.min(n-i,j+1)];
            for(int k = 0 ; k < maListeChar.length ; k++){
                maListeChar[k] = grilleCharactere[i+k][j-k];
            }
            compteur += dictionnaire.compterMot(maListeChar,mots);
            }
        }

        // PRINT OUT
        while (!mots.isEmpty()) {
            System.out.println(mots.poll());
         }

        System.out.println(compteur);
    }


    static void levelOrderTraversal(Node root) { 
    if (root == null) 
        return; 
  
    // Standard level order traversal code 
    // using queue 
    Queue<Node> q = new LinkedList<>(); // Create a queue 
    q.add(root); // Enqueue root  
    while (!q.isEmpty()) 
    { 
        int n = q.size(); 
  
        // If this node has children 
        while (n > 0) 
        { 
            // Dequeue an item from queue 
            // and print it 
            Node p = q.remove();
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
