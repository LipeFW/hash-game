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

        Boolean vezComputador = false;

        if (jogoMapa.sortear(0, 2) == 0) {
            vezComputador = true;
        }

        int jogadas = 0;
        Boolean empate = true;

        jogoMapa.desenhar(jogadas);

        while (jogadas < 9) {
            jogadas++;

            if (vezComputador) {
                if (jogoPC.jogar()) {
                    empate = false;
                    break;
                }

                vezComputador = false;
            } else {
                if (jogoJogador.jogar(teclado)) {
                    empate = false;
                    break;
                }

                vezComputador = true;
            }

            jogoMapa.desenhar(jogadas);
        }

        jogoMapa.desenhar(jogadas);

        if (empate) {
            System.out.println(" ... EMPATOU!");
        }
    }

    public static void main(String[] args) {
        new JogoDaVelha();
    }
}
