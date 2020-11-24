package Peça;

import java.util.Scanner;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Peça {
    private ImageIcon simbolo;
    private int x;
    private int y;
    private String cor;
    private String tipo;
    private String defaultPath = "C:\\Users\\NOC-02\\Desktop\\jogodamas\\Jogo-de-damas\\Imagens\\";
    private ImageIcon imgPecaPreta = new ImageIcon(defaultPath + "Preta fundo transparente.png");
    private ImageIcon pecaPreta = new ImageIcon(imgPecaPreta.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));

    private ImageIcon imgPecaBranca = new ImageIcon(defaultPath + "Branca fundo transparente.png");
    private ImageIcon pecaBranca = new ImageIcon(
            imgPecaBranca.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
    private ImageIcon imgDamaBranca = new ImageIcon(defaultPath + "Dama Branca.png");
    private ImageIcon damaBranca = new ImageIcon(
            imgDamaBranca.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
    private ImageIcon imgDamaPreta = new ImageIcon(defaultPath + "Dama Preta.png");
    private ImageIcon damaPreta = new ImageIcon(
            imgDamaPreta.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));

    public Peça(int x, int y, String cor) {
        if(cor.equals("Branco")){
            this.simbolo = this.pecaBranca;
        }else{
            this.simbolo = this.pecaPreta;
        }
        this.x = x;
        this.y = y;
        this.cor = cor;
        this.tipo = "Comum";
    }
    public ImageIcon getPecaBranca() {
        return this.pecaBranca;
    }
    public ImageIcon getPecaPreta() {
        return this.pecaPreta;
    }
    public boolean validarJogada(String direção, Peça[][] tabuleiro, int casas) {

        int qtdCasas = casas;
        int[] coords = this.decodificaPosição(direção, this.x, this.y, qtdCasas);
        int newX = coords[0];
        int newY = coords[1];
        int newXDama = coords[0];
        int newYDama = coords[1];
        if (newX > 8 || newX < 0 || newY > 8 || newY < 0
                || ((newXDama > 8 || newXDama < 0 || newYDama > 8 || newYDama < 0) && this.tipo.equals("Dama"))) {
            return false;
        }
        if (tabuleiro[newX][newY] != null) {
            if (tabuleiro[newX][newY].getCor().equals(this.cor))
                return false;
        }
        if (tabuleiro[newX][newY] != null) {
            if (!tabuleiro[newX][newY].getCor().equals(this.cor)) {
                int[] futureCoords = this.decodificaPosição(direção, newX, newY, 1);
                int futureX = futureCoords[0];
                int futureY = futureCoords[1];
                if (futureX > 8 || futureX < 0 || futureY > 8 || futureY < 0) {
                    return false;
                } else if (tabuleiro[futureX][futureY] != null && !this.tipo.equals("Dama")) {
                    return false;
                }
            }
        }

        return true;
    }

    private int[] decodificaPosição(String direção, int x, int y, int qtdCasas) {
        int newX = x;
        int newY = y;
        int newXDama = x;
        int newYDama = y;
        switch (direção) {
            case "direita_cima":
                newX--;
                newY++;
                if (qtdCasas > 1) {
                    newXDama = newXDama - qtdCasas;
                    newYDama = newYDama + qtdCasas;
                }
                // Fascista (Bonoro)
                break;
            case "esquerda_cima":
                newX--;
                newY--;
                if (qtdCasas > 1) {
                    newXDama = newXDama - qtdCasas;
                    newYDama = newYDama - qtdCasas;
                }
                // Comunista
                break;
            case "direita_baixo":
                newX++;
                newY++;
                if (qtdCasas > 1) {
                    newXDama = newXDama + qtdCasas;
                    newYDama = newYDama + qtdCasas;
                }
                // Full capetalismo
                break;
            case "esquerda_baixo":
                newX++;
                newY--;
                if (qtdCasas > 1) {
                    newXDama = newXDama + qtdCasas;
                    newYDama = newYDama - qtdCasas;
                }
                // Socialista
                break;
        }
        if (qtdCasas > 1) {
            int[] coords = new int[2];
            coords[0] = newXDama;
            coords[1] = newYDama;
            return coords;
        } else {
            int[] coords = new int[2];
            coords[0] = newX;
            coords[1] = newY;
            return coords;
        }

    }

    public Peça[][] movimentar(String direção, Peça[][] tabuleiro, int qtdCasas) {
        // controla o movimento da peça,
        // idependente se for dama ou não,
        // movimenta a peça para todos os lados,
        // apenas fazer a validação na hora de chamar os métodos.
        // A validação deve verificar se o jogador
        // começou o jogo em cima ou em baixo do tabuleiro
        tabuleiro[this.x][this.y] = null;
        int[] coords = this.decodificaPosição(direção, this.x, this.y, qtdCasas);
        int newX = coords[0];
        int newY = coords[1];
        boolean duasCasas = false;

        if (tabuleiro[newX][newY] != null) {
            if (!tabuleiro[newX][newY].getCor().equals(this.cor)) {
                int[] newCoords = this.decodificaPosição(direção, newX, newY, 1);
                int previousX = newX;
                int previousY = newY;
                newX = newCoords[0];
                newY = newCoords[1];
                this.x = newX;
                this.y = newY;
                this.trasformaEmDama();
                tabuleiro[previousX][previousY] = null;
                tabuleiro[newX][newY] = this;

            }
        } else {
            this.x = newX;
            this.y = newY;
            trasformaEmDama();
            tabuleiro[newX][newY] = this;

        }

        return tabuleiro;
    }

    public ImageIcon getSimbolo() {
        return this.simbolo;
    }

    private void trasformaEmDama() {
        if (this.tipo.equals("Comum") && this.cor.equals("Branco") && this.x == 7) {
            this.tipo = "Dama";
            this.simbolo = this.damaBranca; // caractere da dama branca;
        }
        if (this.tipo.equals("Comum") && this.cor.equals("Preto") && this.x == 0) {
            this.tipo = "Dama";
            this.simbolo = this.damaPreta; // Caracter da dama preta
        }
    }

    public String getCor() {
        return this.cor;
    }

    public String getTipo() {
        return this.tipo;
    }

}
// 