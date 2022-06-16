import java.util.List;

import model.Rolo;
import services.Guloso;
import services.ReadFile;

public class App {

    public static void main(String[] args) throws Exception {
        List<Rolo> rolos = ReadFile.listarRolos("TP2/Codigo/src/files/LaminacaoTeste1.txt");

        for (Rolo rolo : rolos) {
            for (Double rolo2 : rolo.custoPorRecucao()) {
                System.out.println(rolo2);
            }
        }
        /*
         * Guloso guloso = new Guloso();
         * guloso.sequenciaRolos(rolos);
         */

    }

}
