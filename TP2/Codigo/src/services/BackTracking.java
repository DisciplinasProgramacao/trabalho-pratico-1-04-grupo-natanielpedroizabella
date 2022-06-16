package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.Rolo;

public class BackTracking {
    
    public int menorCusto;
    private List<Rolo> rolosSolucao;
    

    public BackTracking() {
        this.menorCusto = 1_000;
        this.rolosSolucao = new ArrayList<>();
    }



    private boolean restricoes(int reducao, int custoAtual) {
        if(custoAtual+reducao>=menorCusto) return false;;
        return true;
    }



    public void backTracking(List<Rolo> rolos, int espessuraChapa, Stack<Rolo> rolosUsados, int custoAtual ) {


        int esp= espessuraChapa;
        Rolo rolo = rolos.stream().filter(x -> x.getEspessuraEntrada() == esp)
                .findFirst().orElse(null);
        
        if(rolo==null){
            this.rolosSolucao.removeAll(this.rolosSolucao);
            rolosUsados.stream().forEach(x->this.rolosSolucao.add(x));
            this.menorCusto=custoAtual;
            return;
        }

        int[] reducoes =rolo.getReducoes();
        for (int i = 0; i < reducoes.length; i++) {
            
            if(restricoes(reducoes[i], custoAtual)){
                rolosUsados.push(rolo);
                custoAtual+=reducoes[i];
                espessuraChapa-=(i+1);
                backTracking(rolos, espessuraChapa, rolosUsados, custoAtual);
                rolosUsados.pop();
                custoAtual-=reducoes[i];
                espessuraChapa+=(i+1);
            }
            
        }

    }



    public int getMenorCusto() {
        return menorCusto;
    }



    public List<Rolo> getRolosSolucao() {
        return rolosSolucao;
    }

}
