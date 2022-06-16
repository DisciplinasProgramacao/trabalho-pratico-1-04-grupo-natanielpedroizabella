import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Rolo;


public class App {

    public static List<Rolo> readFile(String fileName)
            throws FileNotFoundException, NullPointerException {

        List<Rolo> rolers = new ArrayList<>();
        Scanner sc = new Scanner(new File(fileName));

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int[] ctrl = Arrays.stream(str.split(" "))
                    .mapToInt(s -> s.equals("x") ? -1 : Integer.parseInt(s)).toArray();
            rolers.add(new Rolo(ctrl[0], ctrl[1], ctrl[2], ctrl[3]));
        }

        sc.close();
        return rolers;
    }

    public static void main(String[] args) throws Exception {
        List<Rolo> rolers = readFile("src/files/LaminacaoTeste1.txt");

    }

}
