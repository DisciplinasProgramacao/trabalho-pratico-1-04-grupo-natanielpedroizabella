import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Rolo;
import services.ReadFile;


public class App {

    

    public static void main(String[] args) throws Exception {
        List<Rolo> rolos = ReadFile.listarRolos("src/files/LaminacaoTeste1.txt");

    }

}
