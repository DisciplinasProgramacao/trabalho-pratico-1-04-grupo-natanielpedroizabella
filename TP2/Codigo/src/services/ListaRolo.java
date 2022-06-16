package services;

import java.util.List;

import model.Rolo;

public class ListaRolo {

    public static Rolo procurarPelaEspessura(List<Rolo> rolos, int espessura) {

        return rolos.stream()
                .filter(x -> x.getEspessuraEntrada() == espessura)
                .findFirst()
                .orElse(null);
    }

    public static int maiorEspessura(List<Rolo> rolos) {

        return rolos.stream()
                .mapToInt(x -> x.getEspessuraEntrada())
                .max()
                .getAsInt();
    }

    public static int menorEspessura(List<Rolo> rolos) {

        return rolos.stream()
                .mapToInt(x -> x.getEspessuraEntrada())
                .min()
                .getAsInt();
    }

}
