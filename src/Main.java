public class Main {

    public static void main(String[] args){

        String grille = args[0];
        String dictionnaire = args[1];

        //format de lecture java –jar labo2-equipeXX.jar <grille> <dictionnaire>
                
        motCroise myMotCroise = new motCroise(grille,dictionnaire);
        myMotCroise.analyse();
        


    }
}