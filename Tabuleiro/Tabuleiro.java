package Tabuleiro;

import javax.swing.JLabel;

import Peça.Peça;

public class Tabuleiro {
    private String[][] tab = new String[8][8];
    
    public Tabuleiro(){
        
    }
    public void desenhaTabuleiro(Peça[] tab, JLabel[] labelsTabuleiro){
        String strTabuleiro = "";     
        int geraposiçao=0;
        for(Peça p :tab){
            
            if(p != null){
                labelsTabuleiro[geraposiçao].setIcon(p.getSimbolo());
            }else{
                labelsTabuleiro[geraposiçao].setIcon(null);
            }
            
            geraposiçao++;


        }
    }
    
}
