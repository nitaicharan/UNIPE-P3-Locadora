package locadora;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int op = 0;

        ArrayList<Cliente> listCliente = new ArrayList<Cliente>();

        ArrayList<Veiculo> listVeiculo = new ArrayList<Veiculo>();

        Locacao alugado = new Locacao();
        ArrayList<Locacao> listAlugado = new ArrayList<Locacao>();

        while(true) {
            new Clear().clearConsole();
            System.out.print("\n  Locadora de Veiculos\n\n  1 - Cadastrar veículo\n  2 - Cadastrar cliente\n  3 - Locação de veículo\n  4 - Listagem de veículos cadastrados\n  5 - Listagem das locações\n  6 - Listagem de veículos disponíveis\n  7 - Listagem de cliente\n  8 - Sair\n");
            if(op == -666){
                System.out.print("\n  Opção invalida!");
            }
            System.out.print("\n  Escolha uma opcão: ");
            try {
                op = leitor.nextInt();
            } catch (InputMismatchException a) {
                op = -666;
                leitor.nextLine();
            }

            switch (op) {
                case 1:
                    Veiculo veiculo = new Veiculo();
                    veiculo.Cadastrar();
                    while(true) {
                        new Clear().clearConsole();
                        System.out.print("\n  Cadastro veiculo\n\n  Deseja adicionar veiculo\n\n  1 - Sim\n  2 - Não\n");
                        if(op == -666){
    						System.out.print("\n  Tente novamente, Opção invalida");
    					}
                        System.out.print("\n  Escolha uma opcão: ");
                        try {
                            op = leitor.nextInt();
                        } catch (InputMismatchException a) {
                            op = -666;
                            leitor.nextLine();
                        }
                        if(op == 1) {
                            listVeiculo.add(veiculo);
    						break;
    					} else if(op == 2) {
    						break;
    					}
    					op = -666;
                    }
                    break;
                case 2:
                    Cliente cliente = new Cliente();
                    cliente.Cadastrar();
                    while(true) {
                        new Clear().clearConsole();
                        System.out.printf("\n  Cadastro cliente\n\n  Deseja adicionar cadastro: %s\n\n  1 - Sim\n  2 - Não\n", cliente.getNome());
                        if(op == -666){
    						System.out.print("\n  Tente novamente, Opção invalida");
    					}
                        System.out.print("\n  Escolha uma opcão: ");
                        try {
                            op = leitor.nextInt();
                        } catch (InputMismatchException a) {
                            op = -666;
                            leitor.nextLine();
                        }
                        if(op == 1) {
                            listCliente.add(cliente);
    						break;
    					} else if(op == 2) {
    						break;
    					}
    					op = -666;
                    }
                    break;
                case 3:
                    if (listCliente.size() == 0){
                        leitor.nextLine();
                        System.out.println("  Nem um cliente cadastrado!!!");
                        leitor.nextLine();
                    }
                    else {
                      int clienteAL=0;
                      System.out.println("  Clientes disponíveis: ");
                      for(int x = 0; x < listCliente.size(); x++){
                          cliente = listCliente.get(x);
                          System.out.println("  "+x+1 + " " + cliente.getNome());
                      }
                      while(true) {
                        try {
                          System.out.print("\n  Escolha um locatário: ");
                          clienteAL = leitor.nextInt();
                        } catch(InputMismatchException a) {
                          System.out.print("\n  Tente novamente, digite apenas números");
                          leitor.nextLine();
                        }
                        if (clienteAL < listCliente.size() || clienteAL > listCliente.size()) {
                          System.out.println("Favor informar cliente que foram listados!");
                        }
                        else break;
                      }
                      alugado.aluga();
                      listAlugado.add(alugado);
                    }

                    break;
                case 4: // Esta listando todos os cadastros de veiculo para teste

                    System.out.print("    Tipo   Descrição                         Placa\n" + listVeiculo.size());
                    for(int x = 0; x < listVeiculo.size(); x++){
                        System.out.printf("\n%2d  ", x+1);
                        if (listVeiculo.get(x).isTipoVeiculo()){
                            System.out.printf("Carro  %30s  %8s  ", listVeiculo.get(x).getDescricaoVeiculo(), listVeiculo.get(x).getPlacaVeiculo());
                        } else {
                            System.out.printf("Moto   %30s  %8s  ", listVeiculo.get(x).getDescricaoVeiculo(), listVeiculo.get(x).getPlacaVeiculo());
                        }
                    }
                    System.out.print("\n\n  Pressione enter para continuar ");
                    leitor.nextLine();
                    leitor.nextLine();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:// Esta listando todos os cadastros de clientes para teste
                    leitor.nextLine();
                    for(int x = 0; x < listCliente.size(); x++){
                        System.out.println(x+1 + " " + listCliente.get(x).getNome());
                    }
                    System.out.print("Aperte ENTER ");
                    leitor.nextLine();
                    break;
                case 8:
                    System.exit(0);
                default:
                    op = -666; //opção invalida
            }
        }
    }
}
