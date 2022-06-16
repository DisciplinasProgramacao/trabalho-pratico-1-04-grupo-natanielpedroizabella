package services;

import java.util.ArrayList;
import java.util.List;

import model.Rolo;

public class Dinamica {

    private int menorCusto;
    private List<Rolo> rolosSolucao;

    public Dinamica() {
        this.menorCusto = 0;
        this.rolosSolucao = new ArrayList<>();
    }

    public void progamacaoDinamica(List<Rolo> rolos) {

        var tabela=criarTabela(rolos);
        
        int index, referencia;
        for (int i = 2; i < tabela.length; i++) {
            index=0;
            referencia=tabela[i-1][i];
            for (int j = i; j < tabela.length; j++) {
                Rolo rolo = ListaRolo.procurarPelaEspessura(rolos, tabela[0][i]);
                int[] reducoes = rolo.getReducoes();
                if(index<reducoes.length){
                    tabela[j][i]=Math.min(tabela[j][i-1],(reducoes[index]+referencia));
                }else{
                    tabela[j][i]=1_000;
                }
                index++;
            }

            for (int j = i+1; j < tabela.length; j++) {
                tabela[i][j]=tabela[i][i];
            }
            
        }
        
        imprimirTabela(tabela);
        solucoes(tabela, rolos);
    }

    private int[][] criarTabela(List<Rolo> rolos) {


        int espInicial=ListaRolo.maiorEspessura(rolos);
        int espFinal=ListaRolo.menorEspessura(rolos)-1;
        int n =(espInicial-espFinal)+2;
        int[][] tabela=new int[n][n];
        for (int i = 1; i < tabela.length; i++) {

            tabela[0][i]=espInicial+2-i;
            tabela[i][0]=espInicial+1-i;
            tabela[i][1]=1_000;
            tabela[1][i]=0;

        }
        return tabela;
        
    }

    private void imprimirTabela(int[][] tabela){
        for (int i = 0; i < tabela.length; i++) {
            for (int j = 0; j < tabela.length; j++) {
                System.out.printf("|%4d",tabela[j][i]);
            }
            System.out.println("|");
        }

    }
    private void solucoes(int[][] tabela, List<Rolo> rolos){
        int x= tabela.length-1;
        int y= tabela.length-1;
        this.menorCusto=tabela[x][y];
        int primeiroRolo=tabela[0][2];
        int roloEsp = tabela[0][y];
        int custoAtual=tabela[x][y];
        int custoAnterior=tabela[x][y-1];
        Rolo rolo;

        while (roloEsp!=primeiroRolo) {
            while (custoAtual==custoAnterior) {
                custoAtual=custoAnterior;
                y--;
                custoAnterior=tabela[x][y-1];
            }
            roloEsp=tabela[0][y];
            rolo=ListaRolo.procurarPelaEspessura(rolos, roloEsp);
            this.rolosSolucao.add(rolo);
            x-=rolo.getReducoes().length;
            custoAnterior=tabela[x][y-1];
            custoAtual=tabela[x][y]; 
        }
        rolosSolucao.sort((( c1, c2)->c2.getEspessuraEntrada()-c1.getEspessuraEntrada()));

    }

    public int getMenorCusto() {
        return menorCusto;
    }

    public List<Rolo> getRolosSolucao() {
        return rolosSolucao;
    }
    
    
}

