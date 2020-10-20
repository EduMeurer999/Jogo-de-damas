import java.util.Scanner;

import Jogo.Jogo;
import Peça.Peça;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bem vindo ao jogo de damas");
        System.out.println("\n\n1 - Novo Jogo (1 vs 1)");
        System.out.println("2 - Novo Jogo (1 vs Computer)");
        System.out.println("3 - Sair");

        int initOpt;
        do {
            initOpt = teclado.nextInt();
            if (initOpt < 1 || initOpt > 3) {
                System.out.println("Opção inválida!");
                System.out.println("\n\n1 - Novo Jogo (1 vs 1)");
                System.out.println("2 - Novo Jogo (1 vs Computer)");
                System.out.println("3 - Sair");
            }
        } while (initOpt < 1 || initOpt > 3);
        switch (initOpt) {
            case 1:
                Jogo jogo = new Jogo();
                String vezCor;
                vezCor = "Branco";
                do {
                    System.out.println("Vez: "+vezCor);
                    System.out.println("Digite a coordenada: ");
                    String coord;
                    do {
                        coord = teclado.next();
                        if (!jogo.validCoord(coord)) {
                            System.out.println("Coordenada inválida!");
                        }
                    } while (!jogo.validCoord(coord));
                    boolean existsPeça = jogo.existsPeça(vezCor, coord);
                    do {
                        if (existsPeça) {
                            int optMovimento;
                            do {
                                System.out.println("1 - Esquerda");
                                System.out.println("2 - Direita");
                                optMovimento = teclado.nextInt();
                                Peça peçaSelecionada = jogo.returnPeça(coord);
                                String formatarMovimento = peçaSelecionada.getCor() == "Branco" ? "_baixo" : "_cima";
                                int[] coordenadasDaPeça = new int[2];
                                coordenadasDaPeça = jogo.getCoordDaPeça(coord);
                                switch (optMovimento) {
                                    case 1:
                                        if (peçaSelecionada.validarJogada("esquerda" + formatarMovimento,
                                                coordenadasDaPeça[0], coordenadasDaPeça[1])) {
                                            jogo.setPeças(
                                                    peçaSelecionada.movimentar("esquerda"+formatarMovimento, jogo.getPeças()));
                                            jogo.updateTabuleiro();
                                        }else{
                                            optMovimento = 3;
                                        }

                                        break;
                                    case 2:
                                        if (peçaSelecionada.validarJogada("direita" + formatarMovimento,
                                                coordenadasDaPeça[0], coordenadasDaPeça[1])) {
                                            jogo.setPeças(
                                                    peçaSelecionada.movimentar("direita"+formatarMovimento, jogo.getPeças()));
                                            jogo.updateTabuleiro();
                                        }else{
                                            optMovimento = 3;
                                        }

                                        break;
                                    default:
                                        System.out.println("Opção inválida!");
                                        break;
                                }
                            } while (optMovimento != 1 && optMovimento != 2);
                        } else {
                            System.out.println("Você não pode mexer nessa peça!");
                        }
                    } while (!existsPeça);
                    vezCor = vezCor == "Preto" ? "Branco" : "Preto";
                } while (jogo.verificarVitoria() == "");
                break;
            case 2:
                // IA
            case 3:
                break;
            default:
                System.out.println("Opção inválida!");
        }

    }
}