package services;

import java.util.ArrayList;
import java.util.List;

import model.Rolo;

public class Dinamica {

    private int menorCusto;
    private List<Rolo> rolosSolucao;
    private int[][] tabela;

    public Dinamica(List<Rolo> rolos) {
        this.menorCusto = 0;
        this.rolosSolucao = new ArrayList<>();
        this.tabela=criarTabela(rolos);
    }

    public void progamacaoDinamica(List<Rolo> rolos) {

        int index, referencia;
        for (int i = 2; i < this.tabela.length; i++) {
            index = 0;
            referencia = this.tabela[i - 1][i];
            for (int j = i; j < this.tabela.length; j++) {
                Rolo rolo = ListaRolo.procurarPelaEspessura(rolos, this.tabela[0][i]);
                int[] reducoes = rolo.getReducoes();
                if (index < reducoes.length) {
                    this.tabela[j][i] = Math.min(this.tabela[j][i - 1], (reducoes[index] + referencia));
                } else {
                    this.tabela[j][i] = 1_000;
                }
                index++;
            }

            for (int j = i + 1; j < this.tabela.length; j++) {
                this.tabela[i][j] = this.tabela[i][i];
            }

        }
        solucoes(rolos);
    }

    private int[][] criarTabela(List<Rolo> rolos) {

        int espInicial = ListaRolo.maiorEspessura(rolos);
        int espFinal = ListaRolo.menorEspessura(rolos) - 1;
        int n = (espInicial - espFinal) + 2;
        int[][] tabela = new int[n][n];
        for (int i = 1; i < tabela.length; i++) {

            tabela[0][i] = espInicial + 2 - i;
            tabela[i][0] = espInicial + 1 - i;
            tabela[i][1] = 1_000;
            tabela[1][i] = 0;

        }
        tabela[0][0] = 0;
        tabela[0][1] = 0;
        return tabela;

    }

    public void imprimirTabela() {
        for (int i = 0; i < this.tabela.length; i++) {
            for (int j = 0; j < this.tabela.length; j++) {
                System.out.printf("|%4d", this.tabela[j][i]);
            }
            System.out.println("|");
        }

    }

    private void solucoes( List<Rolo> rolos) {
        int index = this.tabela.length - 1;
        this.menorCusto = this.tabela[index][index];
        int primeiroRolo = this.tabela[0][2];
        int roloEsp = this.tabela[0][index];
        int custoAtual = this.tabela[index][index];
        int custoAnterior = this.tabela[index][index - 1];
        Rolo rolo;

        while (roloEsp != primeiroRolo) {
            if (custoAtual != custoAnterior) {
                roloEsp = this.tabela[0][index];
                rolo = ListaRolo.procurarPelaEspessura(rolos, roloEsp);
                this.rolosSolucao.add(rolo);
            }
            index--;
            custoAnterior = this.tabela[index][index - 1];
            custoAtual = this.tabela[index][index];
        }
        rolosSolucao.sort(((c1, c2) -> c2.getEspessuraEntrada() - c1.getEspessuraEntrada()));

    }

    public int getMenorCusto() {
        return menorCusto;
    }

    public List<Rolo> getRolosSolucao() {
        return rolosSolucao;
    }

    public int[][] getTabela() {
        return tabela;
    }

}
