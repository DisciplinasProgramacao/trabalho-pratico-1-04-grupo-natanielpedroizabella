
public class ItemMochila {

    private static char NAME = 'A';

    private char name;
    private int peso;
    private int valor;

    public ItemMochila() {

        this.name = NAME++;
        this.peso = 1;
        this.valor = 1;
    }

    public char getName() {
        return name;
    }

    public int getPeso() {
        return peso;
    }

    public int getValor() {
        return valor;
    }

    public void addPeso(int peso) {
        this.peso += peso;
    }

    public void addValor(int valor) {
        this.valor += valor;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", peso=" + peso + ", valor=" + valor + "]";
    }

}
