import java.util.ArrayList;
import java.util.List;

public class ForcaBruta {

    private static int controle = 1;

    private List<ItemMochila> listaItemMochila = new ArrayList<>();

    public void forcaBruta(ItemMochila arr[], ItemMochila data[], int start, int end, int index, int r,
            int capacidade) {

        if (index == r) {
            List<ItemMochila> iteracaoAtual = new ArrayList<>();
            controle++;

            for (int j = 0; j < r; j++) {

                iteracaoAtual.add(data[j]);

            }
            if (this.listaItemMochila.size() == 0
                    && listaItemMochila.stream().mapToInt(i -> i.getPeso()).sum() <= capacidade) {
                iteracaoAtual.stream().forEach(i -> listaItemMochila.add(i));
            }

            else if (iteracaoAtual.stream().mapToInt(i -> i.getPeso()).sum() <= capacidade &&
                    iteracaoAtual.stream().mapToInt(i -> i.getValor()).sum() > listaItemMochila.stream()
                            .mapToInt(i -> i.getValor()).sum()) {

                listaItemMochila.removeAll(listaItemMochila);

                for (ItemMochila itemMochila : iteracaoAtual) {
                    listaItemMochila.add(itemMochila);
                }
            }
            iteracaoAtual.removeAll(iteracaoAtual);
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            forcaBruta(arr, data, i + 1, end, index + 1, r, capacidade);
        }

    }

    public int getCombinacoes() {
        return controle;
    }

    public List<ItemMochila> getLista() {
        return listaItemMochila;
    }

}
