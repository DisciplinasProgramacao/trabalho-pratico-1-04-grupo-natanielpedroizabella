package services;

import java.util.ArrayList;
import java.util.List;

import model.Rolo;

public class Guloso {

    private List<Rolo> sequenciaRolos = new ArrayList<>();

    public List<Rolo> sequenciaRolos(List<Rolo> rolos) {
        int espessuraMinima = 4;
        int espesssuraReducao = 0;
        int espessuraEntrada = rolos.get(0).getEspessuraEntrada();
        double reducaoOtima = Double.MAX_VALUE;
        int custoReducao = 0;

        for (int i = 0; i < rolos.size(); i++) {
            int j = 0;
            for (Double reducao : rolos.get(i).custoPorRecucao()) {
                if (reducao < reducaoOtima) {
                    reducaoOtima = reducao;
                    espesssuraReducao = j;
                    int[] aux = rolos.get(i).getReducoes();
                    custoReducao = custoReducao + aux[j];
                }
                j++;
            }
            espessuraEntrada = espessuraEntrada - espesssuraReducao;
        }
        return sequenciaRolos;
    }
}
// Faço a redução e depois chamo o get daquela posição.