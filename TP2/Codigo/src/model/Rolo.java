package model;
public class Rolo {

    private int espessuraEntrada;
    private int reducao1mm;
    private int reducao2mm;
    private int reducao3mm;

    public Rolo(int espessuraEntrada, int reducao1mm, int reducao2mm, int reducao3mm) {
        this.espessuraEntrada = espessuraEntrada;
        this.reducao1mm = reducao1mm;
        this.reducao2mm = reducao2mm;
        this.reducao3mm = reducao3mm;
    }

    public int getespessuraEntrada() {
        return espessuraEntrada;
    }

    public void setespessuraEntrada(int espessuraEntrada) {
        this.espessuraEntrada = espessuraEntrada;
    }

    public int getreducao1mm() {
        return reducao1mm;
    }

    public void setreducao1mm(int reducao1mm) {
        this.reducao1mm = reducao1mm;
    }

    public int getreducao2mm() {
        return reducao2mm;
    }

    public void setreducao2mm(int reducao2mm) {
        this.reducao2mm = reducao2mm;
    }

    public int getreducao3mm() {
        return reducao3mm;
    }

    public void setreducao3mm(int reducao3mm) {
        this.reducao3mm = reducao3mm;
    }

    @Override
    public String toString() {
        return "Rolo [espessuraEntrada=" + espessuraEntrada + ", reducao1mm=" + reducao1mm + ", reducao2mm="
                + reducao2mm
                + ", reducao3mm=" + reducao3mm
                + "]";
    }

}
