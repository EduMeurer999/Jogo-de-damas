package Jogo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Peça.Peça;
import Tabuleiro.Tabuleiro;

public class Jogo {
    private Tabuleiro tab;
    private Peça[][] peças = new Peça[8][8];
    private Peça[] peçaSimples = new Peça[64];
    private String[] legendaX = new String[8];
    private String[] legendaY = new String[8];
    private JLabel[] tabuleiro = new JLabel[64];
    private String vez = "Branco";

    public Jogo(JLabel[] tabuleiro) {
        this.tab = new Tabuleiro();
        Peça[][] t = new Peça[8][8];
        boolean pula = false;
        for (int i = 0; i < 3; i++) {
            pula = false;
            for (int j = 0; j < 8; j++) {
                if (i == 1 && j == 0) {
                    pula = true;
                }
                if (!pula) {
                    t[i][j] = new Peça(i, j, "Branco");
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
                    t[i + 5][j] = new Peça(i + 5, j, "Preto");
                    pula = true;
                } else {
                    pula = false;
                }

            }
        }
        this.InsertPeca(tabuleiro, t);

    }

    private void InsertPeca(JLabel[] interfaceTabuleiro, Peça[][] arrPeça) {
        int cont2 = 0;
        Peça[] peçasD = this.decodificaPosicao(arrPeça);
        for (JLabel casa : interfaceTabuleiro) {
            Peça peça = peçasD[cont2];
            if (peça != null) {
                casa.setIcon(peça.getSimbolo());
            }
            casa.addMouseListener(new MouseAdapter() {
                Peça localPeça = peça;

                Peça[][] localArrPeça = arrPeça;
                JLabel[] localInterfaceTabuleiro = interfaceTabuleiro;

                @Override
                public void mouseClicked(MouseEvent e) {

                    String[] options = new String[2];
                    String [] options2 = new String[4];
                    options[0] = "direita";
                    options[1] = "esquerda";
                    String longitude = "";
                    String latitude = "";

                    if (localPeça != null) {
                        if (!localPeça.getCor().equals(vez)) {
                            return;
                        }
                        if (localPeça.getCor().equals("Branco")) {
                            latitude = "_baixo";
                        } else {
                            latitude = "_cima";
                        }
                    } else {
                        return;
                    }
                    int x = -1;
                    boolean éDama = localPeça.getTipo().equals("Dama");
                    if (éDama) {
                        
                        options2[0] = "direita_cima";
                        options2[1] = "esquerda_cima";
                        options2[2] = "direita_baixo";
                        options2[3] = "esquerda_baixo";
                        x = JOptionPane.showOptionDialog(null, "Deseja se mover para qual direção?",
                                "Click a button", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                options2, options2[0]);
                    } else {
                        x = JOptionPane.showOptionDialog(null, "Deseja se mover para direita ou esquerda?",
                                "Click a button", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                options, options[0]);
                    }
                    int qtdCasas = 0;
                    if (!éDama) {
                        if (x == 0) {
                            longitude = "direita";
                        } else if (x == 1) {
                            longitude = "esquerda";
                        } else {
                            return;
                        }
                    }else{
                        boolean deuErro = false;
                        do{
                            try{
                                qtdCasas = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de casas: "));
                            }catch(NumberFormatException erro){
                                deuErro = true;
                            }
                        }while(deuErro);
                    }

                    String direção = éDama ? options2[x] : longitude + latitude;

                    if (!localPeça.validarJogada(direção, localArrPeça, éDama ? qtdCasas: 1)) {
                        JOptionPane.showMessageDialog(null, "Movimento inválido!");
                        return;
                    }
                    Peça[][] newpeças = localPeça.movimentar(direção, localArrPeça, éDama ? qtdCasas : 1);
                    Peça[] arraysimples = decodificaPosicao(newpeças);
                    tab.desenhaTabuleiro(arraysimples, localInterfaceTabuleiro);
                    this.localArrPeça = newpeças;
                    this.localPeça = null;
                    vez = vez.equals("Branco") ? "Preto" : "Branco";
                    InsertPeca(localInterfaceTabuleiro, this.localArrPeça);
                }
            });

            ;
            cont2++;
        }
    }

    private Peça[] decodificaPosicao(Peça[][] peças) {
        Peça[] newPeças = new Peça[64];
        int cont1 = 0;
        for (Peça[] arrP : peças) {
            for (Peça p : arrP) {
                newPeças[cont1] = p;
                cont1++;
            }
        }
        return newPeças;
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
        int x = this.findPosition(String.valueOf(coord.charAt(0)), this.legendaX);
        int y = this.findPosition(String.valueOf(coord.charAt(1)), this.legendaY);
        if (coord.length() == 2) {
            if (x >= 0) {
                if (y >= 0) {
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
