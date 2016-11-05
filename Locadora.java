package locadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Locadora {
    public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      String clear;

        int op = 0;

        while(true) {
            System.out.print("\n\n  Menu\n\n  1 - Cadastrar Veículo\n  2 - Cadastrar Cliente\n  3 - Locação de Veículo\n  4 - Listagem de veículos cadastrados\n  5 - Listagem das locações\n  6 - Listagem de veículos disponíveis\n  7 - Sair\n\n  Escolha uma opcão: ");

            try {
                op = leitor.nextInt();
                clear = leitor.nextLine();
            }catch (InputMismatchException a) {
                System.out.print("\n Erro Input\n");
            }
            switch (op) {
                case 1:
                    break;
                case 2:
                CadastroCliente cliente = new CadastroCliente();
                System.out.print("Digite seu nome: ");
                String nome = leitor.nextLine();
                cliente.setNome(nome);

                System.out.print("Digite sua idade: ");
                try {
                  int idade = leitor.nextInt();
                  cliente.setIdade(idade);
                    clear = leitor.nextLine();
                }catch (InputMismatchException a) {
                    System.out.print("\n Erro Input\n");
                    cliente.setIdade(666);
                    clear = leitor.nextLine();
                }

                if (cliente.getIdade() !=666) {
                  System.out.print("Digite seu cpf: ");
                  try {
                    int cpf = leitor.nextInt();
                    cliente.setCpf(cpf);
                    clear = leitor.nextLine();
                  }catch (InputMismatchException a) {
                      System.out.print("\n Erro Input\n");
                      cliente.setCpf(666);
                      clear = leitor.nextLine();
                  }
                  if (cliente.getCpf()!= 666) {
                    System.out.print("Digite seu numero para contato: ");
                    try {
                      String contato = leitor.nextLine();
                      cliente.setContato(contato);
                    }catch (InputMismatchException a) {
                        System.out.print("\n Erro Input\n");
                        clear = leitor.nextLine();
                    }
                  }
                }
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
