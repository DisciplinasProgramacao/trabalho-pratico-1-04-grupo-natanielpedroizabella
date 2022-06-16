import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.Rolo;
import services.BackTracking;
import services.Guloso;
import services.ReadFile;

public class App {

    public static void main(String[] args) throws Exception {

        String[] arquivos = { "TP2/Codigo/src/files/LaminacaoTeste1.txt",
                "TP2/Codigo/src/files/LaminacaoTeste2.txt",
                "TP2/Codigo/src/files/LaminacaoTeste3.txt",
                "TP2/Codigo/src/files/LaminacaoTeste4.txt",
                "TP2/Codigo/src/files/LaminacaoTeste5.txt"
        };

        int j = 1;
        System.out.println("\n**** Resultados bactracking ****\n");
        for (int i = 0; i < arquivos.length; i++) {
            List<Rolo> rolos = ReadFile.listarRolos(arquivos[i]);
            int espInicial = rolos.stream().mapToInt(x -> x.getEspessuraEntrada()).max().getAsInt();

            BackTracking bt = new BackTracking();

            bt.backTracking(rolos, espInicial, new Stack<Rolo>(), 0);
            System.out.println("Custo BT Teste " + j + ": " + bt.getMenorCusto());
            System.out.println("Rolos BT Teste " + j + "\n" + bt.getRolosSolucao());
            j++;
        }

        j = 1;
        System.out.println("\n**** Resultados guloso ****\n");
        for (int i = 0; i < arquivos.length; i++) {
            List<Rolo> rolos = ReadFile.listarRolos(arquivos[i]);
            int espInicial = rolos.stream().mapToInt(x -> x.getEspessuraEntrada()).max().getAsInt();

            Guloso guloso = new Guloso();

            rolos = guloso.sequenciaRolos(rolos, espInicial);
            System.out.println("Custo Guloso Teste " + j + ": " + guloso.getMenorCusto());
            System.out.println("Rolos Guloso Teste " + j + "\n" + guloso.getSequenciaRolos());
            j++;
        }

    }

}
