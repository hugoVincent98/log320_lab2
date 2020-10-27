public class Main {

    public static void main(String[] args){


        //String grille = args[0];
      //  String dictionnaire = args[1];

        //format de lecture java –jar labo2-equipeXX.jar <grille> <dictionnaire>
           
       String grille = "C:\\Users\\Rajani\\Documents\\GitHub\\log320_lab2\\data_files\\grid1.txt";
        String dictionnaire = "C:\\Users\\Rajani\\Documents\\GitHub\\log320_lab2\\data_files\\dict1.txt";
        MotCroise myMotCroise = new MotCroise(grille,dictionnaire);
        myMotCroise.analyse();

    }
}