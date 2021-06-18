import java.util.Scanner;

public class Jogador {
    private final char letra = 'X';
    private Mapa mapa;

    public Jogador(Mapa mapa) {
        this.mapa = mapa;
    }
    
    public boolean jogar(Scanner teclado) {
        boolean posicaoValida = false;
        while (!posicaoValida) {
            System.out.println("Jogador ..");
    	    System.out.print(" linha: ");
    	    int linha = teclado.nextInt();
            System.out.print(" coluna: ");
            int coluna = teclado.nextInt();

            if ((linha < 0) || (linha > 2) || (coluna < 0) || (coluna > 2)) {
                System.out.println(" posição inválida!");
    		} else {
                if(this.mapa.jogar(linha, coluna, letra)) {
                    posicaoValida = true;
                } else {
                    System.out.println(" posição inválida!");
                }
            }
        }
        if (mapa.verificarGanhador(letra)) {
            System.out.println(" ... Jogador GANHOU!");
            return true;
        }
        return false;
        
    }
}