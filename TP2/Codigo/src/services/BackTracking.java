package services;

import java.util.List;

import model.Rolo;

public class BackTracking {

    public boolean name(List<Rolo> rolos, int proxReducao) {

        Rolo rolo = rolos.stream().filter(x -> x.getEspessuraEntrada() == proxReducao)
                .findFirst().get();

        

        return false;

    }

}
