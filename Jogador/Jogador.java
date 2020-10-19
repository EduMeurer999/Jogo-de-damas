package Jogador;

import Peça.Peça;
import Tabuleiro.Tabuleiro;

public class Jogador {
    private Peça[] peças;
    private String nome;
    private Tabuleiro tabuleiro;
    public Jogador(String nome, Peça[] peças, Tabuleiro tabuleiro){
        this.nome = nome;
        this.peças = peças;
        this.tabuleiro = tabuleiro;
    }
    public Peça[] getPeças() {
        return this.peças;
    }
    public String getNome() {
        return this.nome;
    }
    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    };
    

}
