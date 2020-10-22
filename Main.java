import java.util.Scanner;

import Jogo.Jogo;
import Peça.Peça;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bem vindo ao jogo de damas");
        int initOpt;
        do {
            System.out.println("\n\n1 - Novo Jogo (1 vs 1)");
            System.out.println("2 - Novo Jogo (1 vs Computer) - Coming Soon");
            System.out.println("3 - Informações");
            System.out.println("4 - Sair");
            initOpt = teclado.nextInt();

            switch (initOpt) {
                case 1:
                    Jogo jogo = new Jogo();
                    String vezCor;
                    vezCor = "Branco";
                    do {
                        boolean existsPeça = false;
                        boolean jogadaRealizada = false;
                        do {
                            System.out.println("Vez: " + vezCor);
                            System.out.println("Digite a coordenada: ");
                            String coord;

                            do {
                                coord = teclado.next();
                                if (!jogo.validCoord(coord)) {
                                    System.out.println("Coordenada inválida!");
                                }
                            } while (!jogo.validCoord(coord));

                            existsPeça = jogo.existsPeça(vezCor, coord);
                            if (existsPeça) {
                                int optMovimento = 0;
                                boolean voltar = false;
                                do {
                                    String movimento = "";
                                    boolean optValida = false;
                                    Peça peçaSelecionada = jogo.returnPeça(coord);
                                    do {

                                    } while (optValida);

                                    if (peçaSelecionada.getTipo().equals("Comum")) {
                                        System.out.println("1 - Esquerda");
                                        System.out.println("2 - Direita");
                                        System.out.println("3 - Voltar para tela anterior");
                                        optMovimento = teclado.nextInt();
                                    } else if (peçaSelecionada.getTipo().equals("Dama")) {
                                        System.out.println("1 - Baixo Esquerda");
                                        System.out.println("2 - Baixo Direita");
                                        System.out.println("3 - Cima Esquerda");
                                        System.out.println("4 - Cima Direita");
                                        System.out.println("5 - Voltar para tela anterior");
                                        optMovimento = teclado.nextInt();
                                    }
                                    if (peçaSelecionada.getTipo().equals("Dama")) {
                                        switch (optMovimento) {
                                            case 1:
                                                movimento = "esquerda_baixo";
                                                break;
                                            case 2:
                                                movimento = "direita_baixo";
                                                break;
                                            case 3:
                                                movimento = "esquerda_cima";
                                                break;
                                            case 4:
                                                movimento = "direita_cima";
                                                break;
                                            case 5:
                                                voltar = true;
                                                break;
                                            default:
                                                System.out.println("Opção inválida!");
                                                break;
                                        }
                                    }
                                    String formatarMovimento = peçaSelecionada.getTipo().equals("Comum")
                                            ? peçaSelecionada.getCor().equals("Branco") ? "_baixo" : "_cima"
                                            : movimento;
                                    int[] coordenadasDaPeça = new int[2];
                                    coordenadasDaPeça = jogo.getCoordDaPeça(coord);
                                    if (peçaSelecionada.getTipo().equals("Comum")) {
                                        switch (optMovimento) {
                                            case 1:
                                                if (peçaSelecionada.validarJogada("esquerda" + formatarMovimento,
                                                        coordenadasDaPeça[0], coordenadasDaPeça[1], jogo.getPeças(),
                                                        1)) {
                                                    jogo.setPeças(peçaSelecionada.movimentar(
                                                            "esquerda" + formatarMovimento, jogo.getPeças(), 1));
                                                    jogo.updateTabuleiro();
                                                    jogadaRealizada = true;
                                                } else {
                                                    System.out.println("Jogada inválida");
                                                    jogadaRealizada = false;
                                                }
                                                break;
                                            case 2:
                                                if (peçaSelecionada.validarJogada("direita" + formatarMovimento,
                                                        coordenadasDaPeça[0], coordenadasDaPeça[1], jogo.getPeças(),
                                                        1)) {
                                                    jogo.setPeças(peçaSelecionada.movimentar(
                                                            "direita" + formatarMovimento, jogo.getPeças(), 1));
                                                    jogo.updateTabuleiro();
                                                    jogadaRealizada = true;
                                                } else {
                                                    System.out.println("Jogada inválida");
                                                    optMovimento = 3;
                                                }
                                                break;
                                            case 3:
                                                voltar = true;
                                                jogadaRealizada = false;
                                                break;
                                            default:
                                                System.out.println("Opção inválida!");
                                                voltar = false;
                                                break;
                                        }
                                    } else {
                                        boolean movimentoValido = true;
                                        do {
                                            System.out.println("Quantas casas: ");
                                            int numCasas = teclado.nextInt();
                                            if (peçaSelecionada.validarJogada(formatarMovimento, coordenadasDaPeça[0],
                                                    coordenadasDaPeça[1], jogo.getPeças(), numCasas)) {
                                                jogo.setPeças(peçaSelecionada.movimentar(formatarMovimento,
                                                        jogo.getPeças(), numCasas));
                                                jogo.updateTabuleiro();
                                                jogadaRealizada = true;
                                            } else {
                                                movimentoValido = false;
                                            }
                                        } while (!movimentoValido);

                                    }
                                } while (!jogadaRealizada && !voltar);
                            } else {
                                System.out.println("Você não pode mexer nessa peça!");
                            }
                        } while (!existsPeça || !jogadaRealizada);
                        vezCor = vezCor == "Preto" ? "Branco" : "Preto";
                    } while (jogo.verificarVitoria().equals(""));
                    break;
                case 2:
                    // IA
                case 3:
                    System.out.println(" Dama Preta - \u272A");
                    System.out.println(" Dama Branca - \u235F");
                    System.out.println(" Peça Preta - \u26AB");
                    System.out.println(" Peça Branca - \u26AA");
                    System.out.println("As coordenadas de 1 até 8 & de a até h"
                            + "\nDevem ser digitadas nesse formato: 1a, 2c, 8a, 8h");
                    break;
                case 4:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (initOpt != 4);

    }
}