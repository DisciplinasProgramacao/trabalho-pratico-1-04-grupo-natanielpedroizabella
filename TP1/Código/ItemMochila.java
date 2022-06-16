
public class ItemMochila {

    private static char NAME = 'A';

    private char name;
    private int peso;
    private int valor;
    private Double valorPeso;

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

    public Double getValorPeso(){
        return valorPeso;
    }

    public void addPeso(int peso) {
        this.peso += peso;
    }

    public void addValor(int valor) {
        this.valor += valor;
    }

    public void setVp(){
        this.valorPeso =((double)this.valor/(double)this.peso);
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", peso=" + peso + ", valor=" + valor + "]";
    }

}
