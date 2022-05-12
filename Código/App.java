import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {

    public static ItemMochila[] geradorDeItens(int capacidade, int numeroDeItens) {
        Random random = new Random();
        ItemMochila[] itens = new ItemMochila[numeroDeItens];
        int peso = numeroDeItens;
        int pesoControle = capacidade * 3;
        int pesoAdicional;
        int index = 0;


        //Inserindo valor
        for (int i = 0; i < itens.length; i++) {

            itens[i] = new ItemMochila();
            itens[i].addValor(random.nextInt(9));
        }

        //inserindo o peso
        while (peso < pesoControle) {

            pesoAdicional = (pesoControle - peso > capacidade / 2) ? random.nextInt(capacidade / 2)
                    : 1 + random.nextInt(pesoControle - peso);
            itens[index % numeroDeItens].addPeso(pesoAdicional);
            peso += pesoAdicional;
            index++;
        };

        //Inserindo VP
        for (int i = 0; i < itens.length; i++){
            itens[i].setVp();
        }

        List<ItemMochila> itemMochilas = Arrays.stream(itens).sorted((i1, i2)->-i1.getValorPeso().compareTo(i2.getValorPeso())).collect(Collectors.toList());
        index=0;
        for (ItemMochila itemMochila : itemMochilas) {
            itens[index]=itemMochila;
            index++;
        }
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

        // Força Bruta
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


        
        //Guloso
        Guloso guloso = new Guloso(itemMochila, itemMochila.length-1, 50);
        ItemMochila mochila[] = guloso.mochilaGulosa();
    }
}
