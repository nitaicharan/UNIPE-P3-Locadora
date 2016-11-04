package locadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Locadora {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int op = 0;

        while(true) {
            System.out.print("\n\n  Menu\n\n  1 - Cadastrar Veículo\n  2 - Cadastrar Cliente\n  3 - Locação de Veículo\n  4 - Listagem de veículos cadastrados\n  5 - Listagem das locações\n  6 - Listagem de veículos disponíveis\n  7 - Sair\n\n  Escolha uma opcão: ");

            try {
                op = ler.nextInt();
            }catch (InputMismatchException a) {
                System.out.print("\n Erro Input\n");
                ler.nextLine();
            }
            switch (op) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("\n\n  Opção Invalida!");
            }
        }
    }
}
