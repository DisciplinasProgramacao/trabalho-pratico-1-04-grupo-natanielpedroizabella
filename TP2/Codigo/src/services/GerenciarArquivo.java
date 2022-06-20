package services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Rolo;

public class GerenciarArquivo {

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
    public static BufferedWriter abrirRelatorio() throws IOException {
        return new BufferedWriter( new FileWriter( new File("TP2/Codigo/src/files/relatorio.txt")));
    }

    public static void escreverRelatorio(int teste,Guloso guloso, BackTracking bt, Dinamica pd, BufferedWriter bw, long tempoExecucaoBackTracking, long tempoExecucaoGuloso, long tempoExecucaoDinamica) throws IOException{
        bw.write("\n**** Laminação Teste " + (teste + 1) + " ****\n");
        bw.write("**** Resultados bactracking ****\n");
        bw.newLine();
        bw.write("Custo: " + bt.getMenorCusto());
        bw.newLine();
        bw.write("Rolos usados: " + bt.getRolosSolucao());
        bw.newLine();
        System.out.println("Tempo de execução: " + tempoExecucaoBackTracking);
        bw.newLine();
        bw.write("\n**** Resultados guloso ****\n");
        bw.newLine();
        bw.write("Custo: " + guloso.getMenorCusto());
        bw.newLine();
        bw.write("Rolos usados: " + guloso.getSequenciaRolos());
        bw.newLine();
        System.out.println("Tempo de execução: " + tempoExecucaoGuloso);
        bw.newLine();
        bw.write("\n**** Resultados progamação dinâmica ****\n");
        bw.write("Custo: " + pd.getMenorCusto());
        bw.newLine();
        bw.write("Rolos usados: " + pd.getRolosSolucao()+"\n");
        bw.newLine();
        int[][]tabela =pd.getTabela();
        for (int i = 0; i < tabela.length; i++) {
            for (int j = 0; j < tabela.length; j++) {
                bw.write(String.format("|%4d", tabela[j][i]));
            }
            bw.write("|");
            bw.newLine();
        }
        bw.newLine();
        System.out.println("Tempo de execução: " + tempoExecucaoDinamica);
        
    }
    public static void fecharRelatorio(BufferedWriter bw) throws IOException {
        bw.close();
    }



}
