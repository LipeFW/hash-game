public class PC {

    private Mapa mapa;
    private char letra = 'O';

    public PC(Mapa mapa) {
        this.mapa = mapa;
    }

    public boolean jogar() {
        while (true) {
            var linha = this.mapa.sortear(0, 3);
            var coluna = this.mapa.sortear(0, 3);

            if (this.mapa.jogar(linha, coluna, letra)) {
                System.out.println("PC[" + linha + "," + coluna + "]");
                if (this.mapa.verificarGanhador(letra)) {
                    System.out.println(" ... PC GANHOU!");
                    return true;
                }
                return false;
            }
        }
    }
}