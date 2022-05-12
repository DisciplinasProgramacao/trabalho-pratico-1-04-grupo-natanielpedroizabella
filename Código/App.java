import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class App {

        public static ItemMochila[] geradorDeItens(int capacidade, int numeroDeItens) {
                Random random = new Random();
                ItemMochila[] itens = new ItemMochila[numeroDeItens];
                int peso = numeroDeItens;
                int pesoControle = capacidade * 3;
                int pesoAdicional;
                int index = 0;

                // Inserindo valor
                for (int i = 0; i < itens.length; i++) {

                        itens[i] = new ItemMochila();
                        itens[i].addValor(random.nextInt(9));
                }

                // inserindo o peso
                while (peso < pesoControle) {

                        pesoAdicional = (pesoControle - peso > capacidade / 2) ? random.nextInt(capacidade / 2)
                                        : 1 + random.nextInt(pesoControle - peso);
                        itens[index % numeroDeItens].addPeso(pesoAdicional);
                        peso += pesoAdicional;
                        index++;
                }
                ;

                // Inserindo VP
                for (int i = 0; i < itens.length; i++) {
                        itens[i].setVp();
                }

                List<ItemMochila> itemMochilas = Arrays.stream(itens)
                                .sorted((i1, i2) -> -i1.getValorPeso().compareTo(i2.getValorPeso()))
                                .collect(Collectors.toList());
                index = 0;
                for (ItemMochila itemMochila : itemMochilas) {
                        itens[index] = itemMochila;
                        index++;
                }
                System.out.println(peso);

                return itens;
        }

        public static void main(String[] args) throws Exception {

<<<<<<< HEAD
            pesoAdicional = (pesoControle - peso > capacidade / 2) ? random.nextInt(capacidade / 2)
                    : 1 + random.nextInt(pesoControle - peso);
            itens[index % numeroDeItens].addPeso(pesoAdicional);
            peso += pesoAdicional;
            index++;

        }
        ;

        return itens;
    }

    public static void main(String[] args) throws Exception {

        long tempoInicial;
        long tempoFinal;
        long tempoExecucao;
        int capacidade = 50;
        ItemMochila[] itemMochila;

        List<List<ItemMochila>> listaForcaBruta = new ArrayList<>();

        // Geração itens Mochila
        for (int j = 0; j < 500; j++) {

            itemMochila = geradorDeItens(capacidade, 5);

            // Combinacoes de 1 até N+1 elementos
            tempoInicial = System.currentTimeMillis();
            ForcaBruta forcaBruta = new ForcaBruta();

            for (int i = 1; (i < itemMochila.length + 1); i++) {
                ItemMochila data[] = new ItemMochila[itemMochila.length + 1];
                forcaBruta.forcaBruta(itemMochila, data, 0, itemMochila.length - 1, 0,
                        i, capacidade);
            }
            tempoFinal = System.currentTimeMillis();
            tempoExecucao = tempoFinal - tempoInicial;

            listaForcaBruta.add(forcaBruta.getLista());
        }

        System.out.println("Fim");
    }
=======
                long tempoInicial;
                long tempoFinal;
                long tempoExecucao;
                int capacidade = 50;
                ItemMochila[] itemMochila;

                List<List<ItemMochila>> listaForcaBruta = new ArrayList<>();
                List<List<ItemMochila>> listaGuloso = new ArrayList<>();

                // Geração itens Mochila
                for (int j = 0; j < 500; j++) {

                        itemMochila = geradorDeItens(capacidade, 5);

                        // Combinacoes de 1 até N+1 elementos
                        tempoInicial = System.currentTimeMillis();
                        ForcaBruta forcaBruta = new ForcaBruta();

                        // Guloso
                        Guloso guloso = new Guloso(itemMochila, itemMochila.length - 1, capacidade);
                        List<ItemMochila> solucaoGuloso = guloso.mochilaGulosa();

                        for (int i = 1; (i < itemMochila.length + 1); i++) {
                                ItemMochila data[] = new ItemMochila[itemMochila.length + 1];
                                forcaBruta.forcaBruta(itemMochila, data, 0, itemMochila.length - 1, 0,
                                                i, capacidade);
                        }
                        tempoFinal = System.currentTimeMillis();
                        tempoExecucao = tempoFinal - tempoInicial;

                        // Salvar 500 interações de força bruta
                        listaForcaBruta.add(forcaBruta.getLista());
                        listaGuloso.add(solucaoGuloso);

                }

                System.out.println("Fim");
        }
>>>>>>> branchFinal
}
