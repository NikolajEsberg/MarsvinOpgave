package Homework.Lesson11;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MarsvinTest {
    public static void main(String[] args) {
        new MarsvinTest().run();
    }

    public void nrun() {
        List<Marsvin> marsvinListe = new ArrayList<>();

        // Læs fra fil
        try (Scanner scanner = new Scanner(new File("marsvin.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                String navn = parts[0];
                String race = parts[1];
                int foder = Integer.parseInt(parts[2]);
                marsvinListe.add(new Marsvin(navn, race, foder));
            }
        } catch (IOException e) {
            System.out.println("Fejl ved læsning af fil: " + e.getMessage());
            return;
        }

        // Sorter efter navn og skriv til fil
        marsvinListe.sort(Comparator.comparing(Marsvin::getNavn));
        skrivTilFil(marsvinListe, "navn.txt");

        // Sorter efter race og skriv til fil
        marsvinListe.sort(Comparator.comparing(Marsvin::getRace));
        skrivTilFil(marsvinListe, "race.txt");

        // Sorter efter foder og skriv til fil
        marsvinListe.sort(Comparator.comparingInt(Marsvin::getFoder));
        skrivTilFil(marsvinListe, "foder.txt");
    }

    private void skrivTilFil(List<Marsvin> marsvinListe, String filnavn) {
        try (FileWriter writer = new FileWriter(filnavn)) {
            for (Marsvin m : marsvinListe) {
                writer.write(m.getNavn() + ";" + m.getRace() + ";" + m.getFoder() + "\n");
            }
            System.out.println("Marsvin skrevet til " + filnavn);
        } catch (IOException e) {
            System.out.println("Fejl ved skrivning til fil: " + e.getMessage());
        }
    }
}