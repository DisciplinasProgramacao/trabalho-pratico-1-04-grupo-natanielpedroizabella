import java.util.List;
import java.util.Stack;

import model.Rolo;
import services.BackTracking;
import services.Dinamica;
import services.Guloso;
import services.ListaRolo;
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
            int espInicial = ListaRolo.maiorEspessura(rolos);
            System.out.println("\n**** Laminação Teste " + (i + 1) + " ****\n");
            System.out.println("**** Resultados bactracking ****\n");
            BackTracking bt = new BackTracking();
            bt.backTracking(rolos, espInicial, new Stack<Rolo>(), 0);
            System.out.println("Custo: " + bt.getMenorCusto());
            System.out.println("Rolos usados: " + bt.getRolosSolucao());
            System.out.println("\n**** Resultados guloso ****\n");
            Guloso guloso = new Guloso();
            guloso.sequenciaRolos(rolos, espInicial);
            System.out.println("Custo: " + guloso.getMenorCusto());
            System.out.println("Rolos usados: " + guloso.getSequenciaRolos());
            System.out.println("\n**** Resultados progamação dinâmica ****\n");
            Dinamica pd = new Dinamica();
            pd.progamacaoDinamica(rolos);
            System.out.println("Custo: " + pd.getMenorCusto());
            System.out.println("Rolos usados: " + pd.getRolosSolucao());
        }

    }

}
