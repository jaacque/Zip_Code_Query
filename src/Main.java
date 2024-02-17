import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        ZipcodeQuery zipcodeQuery = new ZipcodeQuery();

        System.out.println("Enter a zip code for query: ");
        var cep = read.nextLine();

        try {
            Address newAddress = zipcodeQuery.addressSearch(cep);
            System.out.println(newAddress);
            FileGenerator generator = new FileGenerator();
            generator.saveJson(newAddress);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finishing the application");
        }

    }
}