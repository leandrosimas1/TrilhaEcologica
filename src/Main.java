import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> paradas = new ArrayList<>();

        while (true) {
            System.out.println("\nItinerário atual: " + paradas);
            System.out.print("Deseja adicionar uma nova parada?");
            String resposta = entrada.nextLine().trim().toLowerCase();

            if (resposta.equals("n")) {
                break;
            } else if (resposta.equals("s")) {
                System.out.print("Digite o nome da parada: ");
                String parada = entrada.nextLine().trim();

                if (paradas.size() == 0) {
                    paradas.add(parada);
                } else {
                    System.out.printf("Informe a posição para inserir (1 a %d): ", paradas.size() + 1);
                    int posicao;
                    while (true) {
                        try {
                            posicao = Integer.parseInt(entrada.nextLine().trim());
                            if (posicao < 1 || posicao > paradas.size() + 1) {
                                System.out.print("Posição inválida. Digite novamente: ");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.print("Digite um número válido: ");
                        }
                    }
                    paradas.add(posicao - 1, parada);
                }
            } else {
                System.out.println("Opção inválida.");
            }
        }

        System.out.println("\nItinerário completo da trilha:");
        for (int i = 0; i < paradas.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, paradas.get(i));
        }
    }
}