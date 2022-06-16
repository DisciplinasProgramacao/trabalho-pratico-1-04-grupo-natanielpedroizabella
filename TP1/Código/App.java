import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class App {

        /**
         * Método gerador de itens aleatórios
         */
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

                // Arrays.stream(itens).forEach(System.out::println);
                // System.out.println(peso);
                return itens;
        }

        public static boolean consultaIguais(List<ItemMochila> listaForcaBruta,
                        List<ItemMochila> listaGuloso) {

                boolean iguais = false;

                if (listaForcaBruta.equals(listaGuloso) == true) {
                        iguais = true;
                }

                return iguais;
        }

        public static void main(String[] args) throws Exception {

                long tempoInicial;
                long tempoFinal;
                long tempoExecucaoGuloso = 0;
                long tempoExecucaoFB = 0;
                int capacidade = 50;
                int iteracoes = 500;
                ItemMochila[] itemMochila;

                List<List<ItemMochila>> listaForcaBruta = new ArrayList<>();
                List<List<ItemMochila>> listaGuloso = new ArrayList<>();
                List<Long> temposGuloso = new ArrayList<>();
                List<Long> temposFB = new ArrayList<>();

                for (int j = 0; j < iteracoes; j++) {

                        itemMochila = geradorDeItens(capacidade, 22);

                        /**
                         * Guloso
                         */
                        tempoInicial = System.currentTimeMillis();
                        Guloso guloso = new Guloso(itemMochila, itemMochila.length - 1, capacidade);
                        List<ItemMochila> solucaoGuloso = guloso.mochilaGulosa();
                        tempoFinal = System.currentTimeMillis();
                        tempoExecucaoGuloso = ((tempoFinal - tempoInicial) / 1000);
                        temposGuloso.add(tempoExecucaoGuloso);

                        /**
                         * Força bruta
                         */
                        tempoInicial = System.currentTimeMillis();
                        ForcaBruta forcaBruta = new ForcaBruta();
                        for (int i = 1; (i < itemMochila.length + 1); i++) {
                                ItemMochila data[] = new ItemMochila[itemMochila.length + 1];
                                forcaBruta.forcaBruta(itemMochila, data, 0, itemMochila.length - 1, 0,
                                                i, capacidade);
                        }
                        tempoFinal = System.currentTimeMillis();
                        tempoExecucaoFB = ((tempoFinal - tempoInicial) / 1000);
                        temposFB.add(tempoExecucaoFB);

                        /**
                         * Salvar 500 iterações
                         */
                        listaForcaBruta.add(forcaBruta.getLista());
                        listaGuloso.add(solucaoGuloso);
                }

                /**
                 * Identificar soluções iguais entre Força Bruta x Guloso
                 */
                int quantidade = 0;
                for (int i = 0; i < iteracoes; i++) {
                        boolean iguais = consultaIguais(listaForcaBruta.get(i), listaGuloso.get(i));
                        if (iguais) {
                                quantidade++;
                        }
                }

                System.out.println("Soluções iguais Força Bruta x Guloso -> " + quantidade);

                System.out.printf(
                                "Tempo médio execução Guloso: %.2f s %n",
                                temposGuloso.stream().mapToDouble(i -> i).average().getAsDouble());
                System.out.printf("Tempo médio execução Força Bruta: %.2f s %n -> ",
                                temposFB.stream().mapToDouble(i -> i).average().getAsDouble());
        }
}
