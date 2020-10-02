package Peça;

public class Peça {
    private String simbolo;
    private int x;
    private int y;
    public Peça(String simbolo, int x, int y) {
        this.simbolo = simbolo;
        this.x = x;
        this.y = y;
    }
    public String[][] movimentar(String direção, String[][] tabuleiro){
        //controla o movimento da peça, 
        //idependente se for dama ou não, 
        //movimenta a peça para todos os lados, 
        //apenas fazer a validação na hora de chamar os métodos. 
        //A validação deve verificar se o jogador 
        //começou o jogo em cima ou em baixo do tabuleiro
        tabuleiro[this.x][this.y] = null;
        int newX = this.x;
        int newY = this.y;
        switch(direção){
            case "direita_cima":
                newX++;
                newY++;
                //Fascista (Bonoro)        
                break;
            case "esquerda_cima":
                newX--;
                newY++;
                //Comunista
                break;
            case "direita_baixo":
                newX++;
                newY--;
                //Full capetalismo                   
                break;
            case "esquerda_baixo":
                newX--;
                newY--;
                //Socialista
                break;
        }

        tabuleiro[newX][newY] = this.simbolo;
        this.x = newX;
        this.y = newY;
        return tabuleiro;
    }
    public String getSimbolo() {
        return this.simbolo;
    }

}
