package services;

import java.util.ArrayList;
import java.util.List;

import model.Rolo;

public class Guloso {

    private List<Rolo> sequenciaRolos = new ArrayList<>();

    public List<Rolo> sequenciaRolos(List<Rolo> rolos) {
        int controleEspessura = 4;

        for (Rolo opcoesRolos : rolos) {
            sequenciaRolos.add(opcoesRolos);
        }

        return sequenciaRolos;
    }
}
