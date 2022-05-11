import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class App {

    public static ItemMochila[] geradorDeItens(int capacidade, int numeroDeItens) {
        Random random = new Random();
        ItemMochila[] itens = new ItemMochila[numeroDeItens];
        int peso = numeroDeItens;
        int pesoControle = capacidade * 3;
        int pesoAdicional;
        int index = 0;

        for (int i = 0; i < itens.length; i++) {

            itens[i] = new ItemMochila();
            itens[i].addValor(random.nextInt(9));

        }

        while (peso < pesoControle) {

            pesoAdicional = (pesoControle - peso > capacidade/2) ? random.nextInt(capacidade/2)
                    : 1 + random.nextInt(pesoControle - peso);
            itens[index % numeroDeItens].addPeso(pesoAdicional);
            peso += pesoAdicional;
            index++;
        }
        ;

        Arrays.stream(itens).forEach(System.out::println);
        System.out.println(peso);

        return itens;
    }

    public static int contador = 0;
    public static int controle = 1;

    public static int combinacoes(ItemMochila arr[], ItemMochila data[], int start, int end, int index, int r) {

        if (index == r) {
            int peso = 0;
            // System.out.print("Nº " + controle + " - ");
            controle++;
            for (int j = 0; j < r; j++) {
                // System.out.print(data[j].getName() + " ");
                peso += data[j].getPeso();
            }
            contador++;
            // System.out.println("- Peso: " + peso);
            // return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinacoes(arr, data, i + 1, end, index + 1, r);
        }
        return contador;
    }

    public static void main(String[] args) throws Exception {

        long tempoInicial;
        long tempoFinal;
        long tempoExecucao;
        ItemMochila[] itemMochila;

        // Geração itens Mochila

        itemMochila = geradorDeItens(50, 25);

        // Geração combinações
        System.out.println("-------Combinacoes--------");

        // Combinacoes de 1 até N+1 elementos
        tempoInicial = System.currentTimeMillis();
        for (int i = 1; (i < itemMochila.length + 1); i++) {
            ItemMochila data[] = new ItemMochila[itemMochila.length + 1];
            combinacoes(itemMochila, data, 0, itemMochila.length - 1, 0,
                    i);
        }
        tempoFinal = System.currentTimeMillis();
        tempoExecucao = tempoFinal - tempoInicial;
        System.out.println("TempoExecucao -> " + tempoExecucao);

        System.out.println("Combinações -> " + controle);
    }
}
