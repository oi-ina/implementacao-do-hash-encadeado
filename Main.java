import java.util.Random;

public class Main {
    static class No {
        int valor;
        No proximo;

        No(int numero) {
            valor = numero;
            proximo = null;
        }
    }

    public static void main(String[] args) {
        No[] matriz = new No[100];
        int[] ultimosTres = new int[3];
        Random random = new Random(1090);
        int totalColisoes = 0;

        for (int i = 0; i < 1000; i++) {
            int numero = random.nextInt(100001);
            int indice = numero % 100;

            // Insere no INICIO, sem precisar percorrer a lista.
            No novo = new No(numero);

            if (matriz[indice] == null) {
                matriz[indice] = novo;
            } else {
                novo.proximo = matriz[indice];
                matriz[indice] = novo;

                ultimosTres[0] = ultimosTres[1];
                ultimosTres[1] = ultimosTres[2];
                ultimosTres[2] = numero;
                totalColisoes++;
            }
        }

        int quantidadeListas = 0;
        int vazias = 0;
        int maiorTamanho = 0;
        int maiorIndice = 0;

        // Conta os nos de cada lista percorrendo os encadeamentos.
        for (int i = 0; i < 100; i++) {
            int tamanho = 0;
            No atual = matriz[i];

            while (atual != null) {
                tamanho++;
                atual = atual.proximo;
            }

            if (tamanho == 0) {
                vazias++;
            }
            if (tamanho >= 2) {
                quantidadeListas++;
            }
            if (tamanho > maiorTamanho) {
                maiorTamanho = tamanho;
                maiorIndice = i;
            }
        }

        System.out.println("TABELA HASH - ENCADEAMENTO");
        System.out.println("Listas criadas por colisao: " + quantidadeListas);
        System.out.println("Posicoes vazias: " + vazias);
        System.out.println("Total de colisoes: " + totalColisoes);
        System.out.println("Maior lista: posicao " + maiorIndice
                + ", com " + maiorTamanho + " elementos");
        System.out.print("Valores da maior lista: ");

        No atual = matriz[maiorIndice];
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }

        System.out.println();
        System.out.println("Ultimos 3 valores inseridos por colisao: "
                + ultimosTres[0] + ", " + ultimosTres[1] + ", " + ultimosTres[2]);
    }
}
