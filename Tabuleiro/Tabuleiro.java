package Tabuleiro;

import Peça.Peça;

public class Tabuleiro {
    private String[][] tab = new String[8][8];
    
    public Tabuleiro(){
        
    }
    public String desenhaTabuleiro(Peça[][] tab, boolean emBranco){
        String strTabuleiro = "";
        if(emBranco){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(i == 0 && j == 0){
                        strTabuleiro += "\n | a | b | c | d | e | f | g | h |\n";
                        strTabuleiro += " |---|---|---|---|---|---|---|---|\n";
                    }
                    if(j == 0){
                        strTabuleiro += ""+(i+1);
                    }
                    
                    strTabuleiro += "|   ";
                    if(j == 7){
                        strTabuleiro += "|\n |---|---|---|---|---|---|---|---|\n";
                    }  
                }
            }
        }       
        else{
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(i == 0 && j == 0){
                        strTabuleiro += "\n |  a  |  b  |  c  |  d  |  e  |  f  |  g  |  h  |\n";
                        strTabuleiro +=   " |-----|-----|-----|-----|-----|-----|-----|-----|\n";
                    }
                    if(j == 0){
                        strTabuleiro += ""+(i+1);
                    }
                    if(tab[i][j] == null){
                        strTabuleiro += "|     ";
                    }else{ 
                        strTabuleiro += "|  "+tab[i][j].getSimbolo()+" ";
                    }
                    
                    if(j == 7){
                        strTabuleiro += "|\n |-----|-----|-----|-----|-----|-----|-----|-----|\n";
                    }
                    
                }
            } 
        }
        return strTabuleiro;
    }

}
