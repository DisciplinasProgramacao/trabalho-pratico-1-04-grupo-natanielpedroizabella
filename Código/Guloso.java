public class Guloso {
    
    private ItemMochila ordenado[];
    private int quantidade;
    private int capacidade;

    public ItemMochila[] getOrdenado() {
        return ordenado;
    }


    public void setOrdenado(ItemMochila[] ordenado) {
        this.ordenado = ordenado;
    }


    public int getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public int getCapacidade() {
        return capacidade;
    }


    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }


    public Guloso(ItemMochila ordenadoVp[], int qtd, int capacidade){
        this.ordenado = new ItemMochila[qtd];
        this.ordenado = ordenadoVp;
        this.quantidade = qtd;
        this.capacidade = capacidade;
    }


    public ItemMochila[] mochilaGulosa (){
        ItemMochila resposta[] = new ItemMochila[quantidade];
        int i = 0;
        for (ItemMochila itemMochila : this.ordenado) {
            if(itemMochila.getPeso() <= this.capacidade){
                resposta[i] = itemMochila;
                i++;
                this.capacidade -= itemMochila.getPeso();
            }
        }

        return resposta;
    }

}
