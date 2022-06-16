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
                "TP2/Codigo/src/files/LaminacaoTeste4.txt"
        };

        System.out.println("\n**** Resultados bactracking ****\n");
        for (int i = 0; i < arquivos.length; i++) {
            List<Rolo> rolos = ReadFile.listarRolos(arquivos[i]);
            int espInicial = rolos.stream().mapToInt(x -> x.getEspessuraEntrada()).max().getAsInt();
            BackTracking bt = new BackTracking();
            bt.backTracking(rolos, espInicial, new Stack<Rolo>(), 0);
            System.out.println("Custo BT Teste " + (i + 1) + ": " + bt.getMenorCusto());
            System.out.println("Rolos BT Teste " + (i + 1) + "\n" + bt.getRolosSolucao());
            System.out.println();
        }

        System.out.println("\n**** Resultados guloso ****\n");
        for (int i = 0; i < arquivos.length; i++) {
            List<Rolo> rolos = ReadFile.listarRolos(arquivos[i]);
            int espInicial = rolos.stream().mapToInt(x -> x.getEspessuraEntrada()).max().getAsInt();
            Guloso guloso = new Guloso();
            rolos = guloso.sequenciaRolos(rolos, espInicial);
            System.out.println("Custo Guloso Teste " + (i + 1) + ": " + guloso.getMenorCusto());
            System.out.println("Rolos Guloso Teste " + (i + 1) + "\n" + guloso.getSequenciaRolos());
            System.out.println();
        }

    }

}
