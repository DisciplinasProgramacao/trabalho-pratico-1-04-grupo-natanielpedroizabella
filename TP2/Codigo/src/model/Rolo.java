package model;

import java.util.Arrays;

public class Rolo {

    private int espessuraEntrada;
    private int[] reducoes;

    public Rolo(int espessuraEntrada, int reducao1mm, int reducao2mm, int reducao3mm) {
        this.espessuraEntrada = espessuraEntrada;
        this.reducoes= new int[]{reducao1mm, reducao2mm, reducao3mm};
    }

    public int getEspessuraEntrada() {
        return espessuraEntrada;
    }

    public int[] getReducoes() {
        return reducoes;
    }

    public double[] custoPorRecucao() {
        double[] custos = new double[3];
        for (int i = 0; i < custos.length; i++) {
            custos[i]=this.reducoes[i]/(i+1);
        }
        return custos;
    }

    @Override
    public String toString() {
        return "Rolo entrada " + espessuraEntrada + "mm, reducoes= " + Arrays.toString(reducoes)+"\n";
    }

  

}
