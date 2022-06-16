package services;

import java.util.ArrayList;
import java.util.List;

import model.Rolo;

public class Guloso {

    private List<Rolo> sequenciaRolos;
    public int menorCusto;

    public Guloso() {
        this.menorCusto = 0;
        this.sequenciaRolos = new ArrayList<>();
    }

    public List<Rolo> sequenciaRolos(List<Rolo> rolos, int espessuraEntrada) {
        int espessuraMinima = 4;
        int espesssuraReducao = 0;
        double custoReducaoOtima = Double.MAX_VALUE;
        int[] aux;

        for (int i = 0; i < rolos.size(); i++) {
            aux = rolos.get(i).getReducoes();
            if (espessuraEntrada >= espessuraMinima) {
                int j = 1;
                custoReducaoOtima = Double.MAX_VALUE;
                for (Double reducao : rolos.get(i).custoPorReducao()) {
                    if (reducao < custoReducaoOtima) {
                        custoReducaoOtima = reducao;
                        espesssuraReducao = j;
                    }
                    j++;
                }
                this.menorCusto += aux[espesssuraReducao - 1];
                sequenciaRolos.add(rolos.get(i));
                i += espesssuraReducao - 1;
                espessuraEntrada = espessuraEntrada - espesssuraReducao;
            }
        }
        return sequenciaRolos;
    }

    public List<Rolo> getSequenciaRolos() {
        return sequenciaRolos;
    }

    public int getMenorCusto() {
        return menorCusto;
    }

}
