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
                    .mapToInt(s -> s.equals("x") ? -1 : Integer.parseInt(s)).toArray();
            rolos.add(new Rolo(ctrl[0], ctrl[1], ctrl[2], ctrl[3]));
        }

        sc.close();
        return rolos;
    }
    
}
