public class Mapa {
    private char[][] mapa = new char[3][3];

    public int sortear(int inicio, int fim) {
        return (int) ((Math.random() * fim) - inicio);
    }

    public void limpar() {
        for (int l = 0; l < mapa.length; l++) {
            for (int c = 0; c < mapa.length; c++) {
                mapa[l][c] = ' ';
            }
        }
    }

    public void desenhar(int jogada) {
        System.out.println("------------- .. jogada: " + jogada);
        System.out.println("| " + mapa[0][0] + " | " + mapa[0][1] + " | " + mapa[0][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + mapa[1][0] + " | " + mapa[1][1] + " | " + mapa[1][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + mapa[2][0] + " | " + mapa[2][1] + " | " + mapa[2][2] + " |");
        System.out.println("----------------------------");
    }

    public boolean jogar(int l, int c, char jogador) {
        if (mapa[l][c] == ' ') {
            mapa[l][c] = jogador;
            return true;
        }

        return false;
    }

    public boolean verificarGanhador(char jogador) {
        for (int i = 0; i < mapa.length; i++) {
            if (mapa[i][0] == jogador && mapa[i][1] == jogador && mapa[i][2] == jogador) {
                return true;
            }

            if (mapa[0][i] == jogador && mapa[1][i] == jogador && mapa[2][i] == jogador) {
                return true;
            }
        }

        if (mapa[0][0] == jogador && mapa[1][1] == jogador && mapa[2][2] == jogador
                || mapa[0][2] == jogador && mapa[1][1] == jogador && mapa[2][0] == jogador) {
            return true;
        }

        return false;
    }
}