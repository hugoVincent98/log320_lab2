import java.time.Duration;
import java.time.Instant;

public class Main {

  public static void main(String[] args) {

    // String grille = args[0];
    // String dictionnaire = args[1];

    // format de lecture java –jar labo2-equipeXX.jar <grille> <dictionnaire>

    Instant start = Instant.now();
    String grille = "C:\\Users\\Rajani\\Documents\\GitHub\\log320_lab2\\data_files\\grid1.txt";
    String dictionnaire = "C:\\Users\\Rajani\\Documents\\GitHub\\log320_lab2\\data_files\\dict1.txt";
    MotCroise myMotCroise = new MotCroise(grille, dictionnaire);
    myMotCroise.analyse();
    Instant end = Instant.now();
    Duration diff = Duration.between(start, end);
    System.out.println("milli: " + diff.toMillis());
    System.out.println(String.format("%d:%02d:%02d", diff.toMinutesPart(), diff.toSecondsPart(), diff.toMillisPart()));

  }
}