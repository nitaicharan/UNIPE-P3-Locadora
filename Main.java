package locadora;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int op = 0;

        Cliente cliente = new Cliente();
        ArrayList<Cliente> listCliente = new ArrayList<Cliente>();

        Veiculo veiculo = new Veiculo();
        ArrayList<Veiculo> listVeiculo = new ArrayList<Veiculo>();

        while(true) {
            System.out.print("\n  Locadora de Veiculos\n\n  1 - Cadastrar veículo\n  2 - Cadastrar cliente\n  3 - Locação de veículo\n  4 - Listagem de veículos cadastrados\n  5 - Listagem das locações\n  6 - Listagem de veículos disponíveis\n  7 - Listagem de cliente\n  8 - Sair\n\n  Escolha uma opcão: ");
            try {
                op = leitor.nextInt();
            } catch (InputMismatchException a) {
                leitor.nextLine();
            }

            switch (op) {
                case 1:
                    veiculo.Cadastrar();
                    listVeiculo.add(veiculo);
                    break;
                case 2:
                    cliente.Cadastrar();
                    listCliente.add(cliente);
                    break;
                case 3:
                    if (listCliente.size() == 0){
                      System.out.println("Nem um cliente cadastrado!!!");
                    }
                    else {
                      int clienteAL;
                      System.out.println("Clientes disponíveis: ");
                      for(int x = 0; x < listCliente.size(); x++){
                          cliente = listCliente.get(x);
                          System.out.println(x+1 + " " + cliente.getNome());
                      }
                      while(true) {
                        clienteAL = leitor.nextInt();
                        try {
                          System.out.print("\n  Escolha um locatário: ");
                        } catch(InputMismatchException a) {
                          System.out.print("\n  Tente novamente, digite apenas números");
                          leitor.nextLine();
                        }
                        if (clienteAL < listCliente.size() || clienteAL > listCliente.size()) {
                          System.out.println("Favor informar cliente que foram listados!");
                        }
                        else break;
                      }

                      

                    }





                    break;
                case 4: // Esta listando todos os cadastros de veiculo para teste
                    for(int x = 0; x < listVeiculo.size(); x++){
                        veiculo = listVeiculo.get(x);
                        System.out.println(x+1 + " " + veiculo.getTipoVeiculo() + " " + veiculo.getDescricaoVeiculo());
                    }
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:// Esta listando todos os cadastros de clientes para teste
                    for(int x = 0; x < listCliente.size(); x++){
                        cliente = listCliente.get(x);
                        System.out.println(x+1 + " " + cliente.getNome());
                    }
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("\n\n  Opção invalida!");
            }
        }
    }
}
