package model;

public class Rolo {

    private int espessuraEntrada;
    private int[] reducoes;

    public Rolo(int espessuraEntrada, int[] reducoes) {
        this.espessuraEntrada = espessuraEntrada;
        this.reducoes = reducoes;
    }

    public int getEspessuraEntrada() {
        return espessuraEntrada;
    }

    public int[] getReducoes() {
        return reducoes;
    }

    public double[] custoPorReducao() {
        double[] custos = new double[this.reducoes.length];
        for (int i = 0; i < custos.length; i++) {
            custos[i] = (double) this.reducoes[i] / (i + 1);
        }
        return custos;
    }

    @Override
    public String toString() {
        return "rolo " + espessuraEntrada + "mm";
    }

}
