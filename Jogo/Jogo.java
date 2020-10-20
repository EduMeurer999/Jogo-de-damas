package Jogo;

import Peça.Peça;
import Tabuleiro.Tabuleiro;

public class Jogo {
    private Tabuleiro tab;
    private Peça[][] peças = new Peça[8][8];
    private String[] legendaX = new String[8];
    private String[] legendaY = new String[8];

    public Jogo() {
        Tabuleiro tab = new Tabuleiro();
        Peça[][] t = new Peça[8][8];
        boolean pula = false;
        this.legendaY[0] = "a";
        this.legendaY[1] = "b";
        this.legendaY[2] = "c";
        this.legendaY[3] = "d";
        this.legendaY[4] = "e";
        this.legendaY[5] = "f";
        this.legendaY[6] = "g";
        this.legendaY[7] = "h";
        this.legendaX[0] = "1";
        this.legendaX[1] = "2";
        this.legendaX[2] = "3";
        this.legendaX[3] = "4";
        this.legendaX[4] = "5";
        this.legendaX[5] = "6";
        this.legendaX[6] = "7";
        this.legendaX[7] = "8";
        for (int i = 0; i < 3; i++) {
            pula = false;
            for (int j = 0; j < 8; j++) {
                if (i == 1 && j == 0) {
                    pula = true;
                }
                if (!pula) {
                    t[i][j] = new Peça("\u26AA", i, j, "Branco");
                    pula = true;
                } else {
                    pula = false;
                }

            }
        }

        for (int i = 0; i < 3; i++) {
            pula = false;
            for (int j = 0; j < 8; j++) {
                if ((i == 0 || i == 2) && j == 0) {
                    pula = true;
                }
                if (!pula) {
                    t[i + 5][j] = new Peça("\u26AB", i + 5, j, "Preto");
                    pula = true;
                } else {
                    pula = false;
                }

            }
        }
        this.peças = t;
        this.tab = tab;
        System.out.println(tab.desenhaTabuleiro(t, false));
    }

    public String verificarVitoria() {
        int peçasBrancas = 0;
        int peçasPretas = 0;
        for (int i = 0; i < this.peças.length; i++) {
            for (int j = 0; j < this.peças[i].length; j++) {
                try {
                    if (this.peças[i][j].getCor() == "Branco") {
                        peçasBrancas++;
                    } else if (this.peças[i][j].getCor() == "Preto") {
                        peçasPretas++;
                    }
                } catch (NullPointerException e) {

                }
            }
        }
        return peçasBrancas == 0 ? "Preto" : peçasPretas == 0 ? "Branco" : "";
    }

    public void jogada(Peça peça) {

    }

    // Jogada composta por um numero e uma letra. Ex: a1, b2, c3;
    public Peça returnPeça(String coord) {
        int x = this.findPosition(String.valueOf(coord.charAt(0)), this.legendaX);
        int y = this.findPosition(String.valueOf(coord.charAt(1)), this.legendaY);
        return this.peças[x][y];
    }

    public boolean existsPeça(String cor, String coord) {
        if (validCoord(coord)) {
            int x = this.findPosition(String.valueOf(coord.charAt(0)), this.legendaX);
            int y = this.findPosition(String.valueOf(coord.charAt(1)), this.legendaY);
            try {
                if (this.peças[x][y].getCor() == cor) {
                    return true;
                }
            } catch (NullPointerException e) {
                return false;
            }
        }
        return false;
    }

    private int findPosition(String value, String[] array) {
        int cont = 0;
        for (String v : array) {
            if (v.equals(value)) {
                return cont;
            }
            cont++;
        }
        return -1;
    }

    public boolean validCoord(String coord) {
        if (coord.length() == 2) {
            if (this.findPosition(String.valueOf(coord.charAt(0)), this.legendaX) >= 0) {
                if (this.findPosition(String.valueOf(coord.charAt(1)), this.legendaY) >= 0) {
                    return true;
                }
            }
        }
        return false;

    }

    public Tabuleiro getTab() {
        return this.tab;
    }

    public Peça[][] getPeças() {
        return this.peças;
    }

    public void setPeças(Peça[][] peças) {
        this.peças = peças;
    }

    public void updateTabuleiro() {
        System.out.println(this.tab.desenhaTabuleiro(this.peças, false));
    }

    public int[] getCoordDaPeça(String coord) {
        System.out.println(this.findPosition(String.valueOf(coord.charAt(0)), this.legendaX));
        System.out.println(this.findPosition(String.valueOf(coord.charAt(1)), this.legendaY));
        int x = this.findPosition(String.valueOf(coord.charAt(0)), this.legendaX);
        int y = this.findPosition(String.valueOf(coord.charAt(1)), this.legendaY);
        int[] c = new int[2];
        c[0] = x;
        c[1] = y;
        return c;
    }
}
