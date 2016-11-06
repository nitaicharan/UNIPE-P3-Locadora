package locadora;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Cliente cliente = new Cliente();
        ArrayList<Cliente> listCliente = new ArrayList<Cliente>();
        int op = 0;

        while(true) {
            System.out.print("\n\n  Menu\n\n  1 - Cadastrar Veículo\n  2 - Cadastrar Cliente\n  3 - Locação de Veículo\n  4 - Listagem de veículos cadastrados\n  5 - Listagem das locações\n  6 - Listagem de veículos disponíveis\n  7 - Sair\n\n  Escolha uma opcão: ");
            try {
                op = leitor.nextInt();
            } catch (InputMismatchException a) {
                leitor.nextLine();
            }

            switch (op) {
                case 1:
                    break;
                case 2:
                    cliente.Cadastrar();
                    listCliente.add(cliente);
                    break;
                case 3: // Esta listando todos os cadastros de clientes para teste
                    for(int x = 0; x < listCliente.size(); x++){
                        cliente = listCliente.get(x);
                        System.out.println(x+1 + " " + cliente.getNome());
                    }
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
