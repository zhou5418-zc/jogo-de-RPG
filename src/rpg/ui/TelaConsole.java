package rpg.ui;

import java.util.Scanner;

// Implementação da Tela usando o terminal.
public class TelaConsole implements Tela {
    private Scanner scanner = new Scanner(System.in);

    public void mostrar(String texto) {
        System.out.println(texto);
    }

    public void titulo(String texto) {
        System.out.println();
        System.out.println("========================================");
        System.out.println("  " + texto);
        System.out.println("========================================");
    }

    // Pergunta até o jogador digitar um número válido.
    public int lerNumero(String pergunta, int min, int max) {
        while (true) {
            String linha = lerTexto(pergunta);
            try {
                int numero = Integer.parseInt(linha.trim());
                if (numero >= min && numero <= max) {
                    return numero;
                }
            } catch (NumberFormatException e) {
                // não era número: mostra o aviso abaixo
            }
            System.out.println("Opção inválida! Digite de " + min + " a " + max + ".");
        }
    }

    public String lerTexto(String pergunta) {
        System.out.print(pergunta);
        return scanner.nextLine();
    }
}
