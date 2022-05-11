import java.util.ArrayList;
import java.util.List;

public class ForcaBruta {

    private static int controle = 1;

    private List<ItemMochila> listaItemMochila = new ArrayList<>();

    public void forcaBruta(ItemMochila arr[], ItemMochila data[], int start, int end, int index, int r) {

        if (index == r) {
            int peso = 0;
            int valor = 0;
            String itens = "";
            // System.out.print("Nº " + controle + " - ");
            controle++;
            for (int j = 0; j < r; j++) {
                // System.out.print(data[j].getName() + " ");
                itens += (data[j].getName() + " ");
                peso += data[j].getPeso();
                valor += data[j].getValor();
                listaItemMochila.add(data[j]);
            }

            // System.out.print(itens);
            // System.out.print("- Peso: " + peso);
            // System.out.println(" - Valor: " + valor);
            // return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            forcaBruta(arr, data, i + 1, end, index + 1, r);
        }

    }

    public int getCombinacoes() {
        return controle;
    }

    public List<ItemMochila> getLista() {
        return listaItemMochila;
    }

}
