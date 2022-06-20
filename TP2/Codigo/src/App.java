import java.io.BufferedWriter;
import java.util.List;
import java.util.Stack;

import model.Rolo;
import services.BackTracking;
import services.Dinamica;
import services.GerenciarArquivo;
import services.Guloso;
import services.ListaRolo;

public class App {

    public static void main(String[] args) throws Exception {

        
        long tempoExecucaoInicial = 0;
        long tempoExecucaoFinal = 0;
        long tempoExecucaoBackTracking = 0;
        long tempoExecucaoGuloso = 0;
        long tempoExecucaoDinamica = 0;

        BufferedWriter bw = GerenciarArquivo.abrirRelatorio();

        String[] arquivos = { "TP2/Codigo/src/files/LaminacaoTeste1.txt",
                "TP2/Codigo/src/files/LaminacaoTeste2.txt",
                "TP2/Codigo/src/files/LaminacaoTeste3.txt",
                "TP2/Codigo/src/files/LaminacaoTeste4.txt"
        };

       

        for (int i = 0; i < arquivos.length; i++) {

            List<Rolo> rolos = GerenciarArquivo.listarRolos(arquivos[i]);
            int espInicial = ListaRolo.maiorEspessura(rolos);

            System.out.println("\n\n--------Laminação Teste " + (i + 1) + "--------\n");
            System.out.println("**** Resultados backtracking ****\n");

            BackTracking bt = new BackTracking();
            tempoExecucaoInicial = System.currentTimeMillis();
            bt.backTracking(rolos, espInicial, new Stack<Rolo>(), 0);
            tempoExecucaoFinal = System.currentTimeMillis();

            tempoExecucaoBackTracking = ((tempoExecucaoFinal - tempoExecucaoInicial) / 1000);

            System.out.println("Custo: " + bt.getMenorCusto());
            System.out.println("Rolos usados: " + bt.getRolosSolucao());
            System.out.println("Tempo de execução: " + tempoExecucaoBackTracking);


            System.out.println("\n**** Resultados guloso ****\n");

            Guloso guloso = new Guloso();
            tempoExecucaoInicial = System.currentTimeMillis();
            guloso.sequenciaRolos(rolos, espInicial);
            tempoExecucaoFinal = System.currentTimeMillis();

            tempoExecucaoGuloso = ((tempoExecucaoFinal - tempoExecucaoInicial) / 1000);

            System.out.println("Custo: " + guloso.getMenorCusto());
            System.out.println("Rolos usados: " + guloso.getSequenciaRolos());
            System.out.println("Tempo de execução: " + tempoExecucaoGuloso);
            

            System.out.println("\n**** Resultados progamação dinâmica ****\n");

            Dinamica pd = new Dinamica(rolos);
            tempoExecucaoInicial = System.currentTimeMillis();
            pd.progamacaoDinamica(rolos);
            tempoExecucaoFinal = System.currentTimeMillis();

            tempoExecucaoDinamica = ((tempoExecucaoFinal - tempoExecucaoInicial) / 1000);

            System.out.println("Custo: " + pd.getMenorCusto());
            System.out.println("Rolos usados: " + pd.getRolosSolucao() + "\n");
            System.out.println("Tempo de execução: " + tempoExecucaoDinamica);
            pd.imprimirTabela();

            GerenciarArquivo.escreverRelatorio(i, guloso, bt, pd, bw, tempoExecucaoBackTracking, tempoExecucaoGuloso, tempoExecucaoDinamica);
        }
        GerenciarArquivo.fecharRelatorio(bw);

    }

}
