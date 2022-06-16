import java.util.List;

import model.Rolo;
import services.ReadFile;


public class App {


    public static void main(String[] args) throws Exception {
        List<Rolo> rolos = ReadFile.listarRolos("src/files/LaminacaoTeste1.txt");
       System.out.println(rolos);

    }

}
