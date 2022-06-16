package services;

import java.util.List;

import model.Rolo;

public class Dinamica {

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
    private void solucoes(int[][] tabela){
        for (int i = 0; i < tabela.length; i++) {
            for (int j = 0; j < tabela.length; j++) {
                
            }
            
        }

    }
    
}

