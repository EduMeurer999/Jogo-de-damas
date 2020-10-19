package Peça;

import java.util.Scanner;

public class Peça {
    private String simbolo;
    private int x;
    private int y;
    private String cor;
    private String tipo;

    public Peça(String simbolo, int x, int y, String cor) {
        this.simbolo = simbolo;
        this.x = x;
        this.y = y;
        this.cor = cor;
        this.tipo = "Comum";
    }

    public boolean validarJogada(String direção, int x, int y) {

        if (this.cor == "Branco" && this.tipo == "Comum") {
            if (direção != "direita_cima" && direção != "esquerda_cima") {
                return false;
            }
        } else if (this.cor == "Preto" && this.tipo == "Comum") {
            if (direção != "direita_baixo" && direção != "esquerda_baixo") {
                return false;
            }
        }
        if (x > 8 || x < 0 || y > 8 || y < 0) {
            return false;
        }

        return true;
    }

    public String[][] movimentar(String direção, String[][] tabuleiro) {
        // controla o movimento da peça,
        // idependente se for dama ou não,
        // movimenta a peça para todos os lados,
        // apenas fazer a validação na hora de chamar os métodos.
        // A validação deve verificar se o jogador
        // começou o jogo em cima ou em baixo do tabuleiro
        tabuleiro[this.x][this.y] = null;
        int newX = this.x;
        int newY = this.y;
        boolean duasCasas = false;
        if (this.tipo == "Dama") {
            String opt;
            System.out.println("Você escolheu movimentar uma dama\nDeseja move-la 2 casas");
            do {
                Scanner scan = new Scanner(System.in);
                opt = scan.next();
                if (opt != "S" && opt != "N")
                    System.out.println("Opão inválida!\n");
                if (opt == "S") {
                    duasCasas = true;
                    scan.close();
                }
            } while (opt != "S" && opt != "N");

        }
        switch (direção) {
            case "direita_cima":
                newX++;
                newY++;
                if (duasCasas){
                    newX++;
                    newY++;
                }
                // Fascista (Bonoro)
                break;
            case "esquerda_cima":
                newX--;
                newY++;
                if (duasCasas){
                    newX--;
                    newY++;
                }
                // Comunista
                break;
            case "direita_baixo":
                newX++;
                newY--;
                if (duasCasas){
                    newX++;
                    newY--;
                }
                // Full capetalismo
                break;
            case "esquerda_baixo":
                newX--;
                newY--;
                if (duasCasas){
                    newX--;
                    newY--;
                }
                // Socialista
                break;
        }

        
        if (this.tipo == "Comum" && this.cor == "Branco" && newY == 7) {
            this.tipo = "Dama";
            this.simbolo = "\u235F"; // caractere da dama branca;
        }
        if (this.tipo == "Comum" && this.cor == "Preto" && newY == 0) {
            this.tipo = "Dama";
            this.simbolo = "\u272A"; // Caracter da dama preta
        }
        
        if(this.validarJogada(direção, newX, newY)){
            this.x = newX;
            this.y = newY;
            tabuleiro[newX][newY] = this.simbolo;
        }
        return tabuleiro;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public String getCor() {
        return this.cor;
    }

}
