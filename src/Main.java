import java.time.Duration;
import java.time.Instant;

public class Main {

  public static void main(String[] args) {

     String grille = args[0];
     String dictionnaire = args[1];

    // format de lecture java –jar labo2-equipeXX.jar <grille> <dictionnaire>

    MotCroise myMotCroise = new MotCroise(grille, dictionnaire);
    myMotCroise.analyse();

  }
}