import java.util.Scanner;

import Jogo.Jogo;
import Peça.Peça;
import Jogo.Interface;

public class Main {

    public static void main(String[] args) {

        try {
            Interface i = new Interface();
            i.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}