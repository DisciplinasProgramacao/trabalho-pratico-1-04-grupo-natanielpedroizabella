package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Rolo;

public class ReadFile {

    public static List<Rolo> listarRolos(String fileName)
            throws FileNotFoundException, NullPointerException {

        List<Rolo> rolos = new ArrayList<>();
        Scanner sc = new Scanner(new File(fileName));

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int[] ctrl = Arrays.stream(str.split(" "))
                    .filter(s -> s.length() >= 1)
                    .mapToInt(s -> s.equals("x") ? -1 : Integer.parseInt(s))
                    .filter(x -> x > 0).toArray();

            rolos.add(new Rolo(ctrl[0], Arrays.copyOfRange(ctrl, 1, ctrl.length)));
        }

        sc.close();
        return rolos;
    }

}
