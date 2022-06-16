package services;

import java.util.List;

import model.Rolo;

public class Dinamica {

    public static void name(List<Rolo> rolos) {

        
        int espInicial=rolos.stream().mapToInt(x -> x.getEspessuraEntrada()).max().getAsInt();
        int espFinal=rolos.stream().mapToInt(x -> x.getEspessuraEntrada()).min().getAsInt()-1;
        int n =(espInicial-espFinal)+2;
        int[][] tabela=new int[n][n];
        for (int i = 1; i < tabela.length; i++) {

            tabela[0][i]=espInicial+2-i;
            tabela[1][i]=0;
            tabela[i][0]=espInicial+1-i;
            tabela[i][1]=1_000;

        }
        int index, referencia;
        for (int i = 2; i < tabela.length; i++) {
            index=0;
            referencia=tabela[i-1][i];
            for (int j = i; j < tabela.length; j++) {
                int esp = tabela[0][i];
                Rolo rolo = rolos.stream().filter(x -> x.getEspessuraEntrada() == esp)
                .findFirst().get();
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
        for (int i = 0; i < tabela.length; i++) {
            for (int j = 0; j < tabela.length; j++) {
                System.out.printf("|%4d",tabela[j][i]);
            }
            System.out.println("|");
        }
        
        


        
    }
    
}
