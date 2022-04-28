public class ItemMochila {

    private int peso;
    private int valor;

    public ItemMochila(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ItemMochila [peso=" + peso + ", valor=" + valor + "]";
    }

}
