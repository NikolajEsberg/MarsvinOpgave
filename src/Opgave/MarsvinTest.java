package Opgave;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarsvinTest {
    public static void main(String[] args){
        //Array liste med marsvinene
        List<String[]> marsvin = new ArrayList<>();
        marsvin.add(new String[]{"Pjuske", "Roset", "30"});
        marsvin.add(new String[]{"Putte", "Glathåret", "55"});
        marsvin.add(new String[]{"Lunte", "Roset", "36"});
        marsvin.add(new String[]{"Perle", "Roset", "38"});
        marsvin.add(new String[]{"Banse", "Angore", "60"});

        try (FileWriter writer = new FileWriter("Marsvin.csv")) {
            writer.write("Name,Race,Foder (hvor mange gram foder det spiser om dagen)\n");

            for (String[] marsvinen : marsvin){
                writer.write(String.join(";", marsvinen) + "\n");
            }

            System.out.println("Marsvinene er skrevet til Marsvin.csv (sepereret af semicolon)");
        } catch (IOException e) {
            System.out.println("Fejl ved skrivning til fil: " + e.getMessage());
        }
    }
}
