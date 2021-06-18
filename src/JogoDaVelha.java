import java.util.Scanner;

public class JogoDaVelha {
    private Mapa jogoMapa;
    private Jogador jogoJogador;
    private PC jogoPC;

    private JogoDaVelha() {
        Scanner teclado = new Scanner(System.in);

        jogoMapa = new Mapa();
        jogoPC = new PC(jogoMapa);
        jogoJogador = new Jogador(jogoMapa);

        char opcao = 's';

        while (opcao == 's') {
            jogar(teclado);

            System.out.println();
            System.out.println("________________________");
            System.out.println("Deseja jogar novamente? (s/n)");
            opcao = teclado.next().toLowerCase().charAt(0);
        }

        teclado.close();

        System.out.println("--- FIM ---");
    }

    private void jogar(Scanner teclado) {
        jogoMapa.limpar();

        Boolean alternar = false;

        if (jogoMapa.sortear(0, 2) == 0) {
            alternar = true;
        }

        int jogada = 0;
        Boolean empate = true;

        jogoMapa.desenhar(jogada);

        while (jogada < 9) {
            jogada++;

            if (alternar) {
                if (jogoPC.jogar()) {
                    empate = false;
                    break;
                }

                alternar = false;
            } else {
                if (jogoJogador.jogar(teclado)) {
                    empate = false;
                    break;
                }

                alternar = true;
            }

            jogoMapa.desenhar(jogada);
        }

        jogoMapa.desenhar(jogada);

        if (empate) {
            System.out.println(" ... EMPATOU!");
        }
    }

    public static void main(String[] args) {
        new JogoDaVelha();
    }
}
