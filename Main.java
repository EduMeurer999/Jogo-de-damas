import Peça.Peça;
import Tabuleiro.Tabuleiro;

public class Main {

    public static void main(String[] args) {
        Tabuleiro tab = new Tabuleiro();
        Peça[][] t = new Peça[8][8];
        boolean pula = false;
        for (int i = 0; i < 3; i++) {
            pula = false;
            for (int j = 0; j < 8; j++) {
                if(i == 1 && j == 0){
                    pula = true;
                }
                if (!pula) {
                    t[i][j] = new Peça("\u26AA", i, j);
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
                    t[i+5][j] = new Peça("\u26AB", i+5, j);
                    pula = true;
                }else{
                    pula=false;
                }
                
            }
        }
        System.out.println(tab.desenhaTabuleiro(t, false));
    }
}