package Jogo;

import Peça.Peça;
import Tabuleiro.Tabuleiro;

public class Jogo {
    private Tabuleiro tab;
    private Peça[][] peças = new Peça[8][8];
    private String[] legendaX = new String[8];
    private String[] legendaY = new String[8];

    public Jogo(){
        Tabuleiro tab = new Tabuleiro();
        Peça[][] t = new Peça[8][8];
        boolean pula = false;
        this.legendaX[0] = "a";
        this.legendaX[1] = "b";
        this.legendaX[2] = "c";
        this.legendaX[3] = "d";
        this.legendaX[4] = "e";
        this.legendaX[5] = "f";
        this.legendaX[6] = "g";
        this.legendaX[7] = "h";
        this.legendaY[0] = "1";
        this.legendaY[1] = "2";
        this.legendaY[2] = "3";
        this.legendaY[3] = "4";
        this.legendaY[4] = "5";
        this.legendaY[5] = "6";
        this.legendaY[6] = "7";
        this.legendaY[7] = "8";
        for (int i = 0; i < 3; i++) {
            pula = false;
            for (int j = 0; j < 8; j++) {
                if(i == 1 && j == 0){
                    pula = true;
                }
                if (!pula) {
                    t[i][j] = new Peça("\u26AA", i, j, "Branco");
                    pula = true;
                }else{
                    pula=false;
                }
                
            }
        }
        
        for (int i = 0; i < 3; i++) {
            pula = false;
            for (int j = 0; j < 8; j++) {
                if((i == 0 || i == 2) && j == 0){
                    pula = true;
                }
                if (!pula) {
                    t[i+5][j] = new Peça("\u26AB", i+5, j, "Preto");
                    pula = true;
                }else{
                    pula=false;
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
                if (this.peças[i][j].getCor() == "Branco") {
                    peçasBrancas++;
                } else if (this.peças[i][j].getCor() == "Preto") {
                    peçasPretas++;
                }
            }
        }
        return peçasBrancas == 0 ? "Preto" : peçasPretas == 0 ? "Branco" : "";
    }

    public void jogada(Peça peça) {

    }
    //Jogada composta por um numero e uma letra. Ex: a1, b2, c3;
    public boolean validarJogada(String jogadaOrigem, String jogadaDestino, Peça peça, String movimento) {
        int origemX = findPosition(String.valueOf(jogadaOrigem.charAt(0)), this.legendaX);
        int destinoX = findPosition(String.valueOf(jogadaDestino.charAt(0)), this.legendaX);
        int origemY = findPosition(String.valueOf(jogadaDestino.charAt(1)), this.legendaY);
        int destinoY = findPosition(String.valueOf(jogadaDestino.charAt(1)), this.legendaY);
        if(this.peças[origemX][origemY] != null){
            if(this.peças[destinoX][destinoY] == null){
                
                return true;
            }
        }
        System.out.println("Jogada Inválida, por favor verifique as coordenadas digitadas!");
        return false;
    }
    private int findPosition(String value, String[] array){
        int cont = 0;
        for(String v : array){
            if(v.equals(value)){
                return cont;
            }
            cont++;
        }
        return -1;
    }
}
