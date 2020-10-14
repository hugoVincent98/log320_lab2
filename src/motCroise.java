import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.CacheResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class motCroise {

    String grilleFile;
    String dictFile;
    char[][] grilleCharactere;
    List<char[]> dictMot = new ArrayList<char[]>();
    int n;

    public motCroise(String grilleFile, String dictFile){
        this.grilleFile = grilleFile;
        this.dictFile = dictFile;
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



        //mettre le fichier grille dans un tableau de char
        try {
            File myObj = new File(dictFile);
            Scanner myReader = new Scanner(myObj);

            //permet de passer sur chaque ligne de la grille et de cree un tableau de char qui sera plus facile a travaille avec
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                
                char[] mot  = new char[data.length()];
                for(int i = 0; i < data.length(); i++){
                    mot[i] =data.charAt(i);
                }

                dictMot.add(mot);
                
            }
            myReader.close();

            /*for(char[] charArray : dictMot){
                
                //iterate through array using its length
                for(int i = 0 ; i < charArray.length; i++){
                    System.out.print( charArray[i]);
                }
                
                System.out.println();
            }*/

        }catch (FileNotFoundException e) {
            System.out.println("Un probleme est survenu");
            e.printStackTrace();
        }

    }
    
    
}
