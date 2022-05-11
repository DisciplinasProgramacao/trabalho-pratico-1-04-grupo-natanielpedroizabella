import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

            pesoAdicional = (pesoControle - peso > capacidade / 2) ? random.nextInt(capacidade / 2)
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

    public static void main(String[] args) throws Exception {

        long tempoInicial;
        long tempoFinal;
        long tempoExecucao;
        ItemMochila[] itemMochila;

        // Geração itens Mochila

        itemMochila = geradorDeItens(50, 5);

        // Geração combinações
        System.out.println("-------Combinacoes--------");

        // Combinacoes de 1 até N+1 elementos
        tempoInicial = System.currentTimeMillis();
        ForcaBruta forcaBruta = new ForcaBruta();
        for (int i = 1; (i < itemMochila.length + 1); i++) {
            ItemMochila data[] = new ItemMochila[itemMochila.length + 1];
            forcaBruta.forcaBruta(itemMochila, data, 0, itemMochila.length - 1, 0,
                    i);
        }
        tempoFinal = System.currentTimeMillis();
        tempoExecucao = tempoFinal - tempoInicial;
        System.out.println("TempoExecucao -> " + tempoExecucao);

        List<ItemMochila> listaItemMochila = forcaBruta.getLista();

        System.out.println("Combinações -> " + forcaBruta.getCombinacoes());

    }
}
