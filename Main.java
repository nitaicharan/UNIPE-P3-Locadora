package locadora;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int op = 0;

        ArrayList<Cliente> listCliente = new ArrayList<Cliente>();
        ArrayList<Veiculo> listVeiculo = new ArrayList<Veiculo>();
        ArrayList<Locacao> listAlugado = new ArrayList<Locacao>();

        while(true) {
            clearConsole();
            System.out.print("\n  Locadora de Veiculos\n\n  1 - Cadastrar veículo\n  2 - Cadastrar cliente\n  3 - Locação de veículo\n  4 - Listagem de veículos cadastrados\n  5 - Listagem das locações\n  6 - Listagem de veículos disponíveis\n  7 - Listagem de cliente\n  8 - Sair\n");
            if(op == -666){
                System.out.print("\n  Opção invalida!");
            }
            System.out.print("\n  Escolha uma opcão: ");
            op = inputInt();

            switch (op) {
                case 1:
                    Veiculo veiculo = new Veiculo();
                    cadastrarVeiculo(veiculo);
                    if(confirmacaoBoolean("Cadastro de veiculo", "Sim", "Não")){
                        listVeiculo.add(veiculo);
                    }
                    break;
                case 2:
                    Cliente cliente = new Cliente();
                    cadastrarCliente(cliente);
                    if(confirmacaoBoolean("Cadastro de cliente", "Sim", "Não")){
                        listCliente.add(cliente);
                    }
                    break;
                case 3:
                    if (listCliente.isEmpty()){
                        clearConsole();
                        pause("Locação de veículo\n\n  Nem um cliente cadastrado\n\n  Pressione enter para voltar");
                    }
                    else {
                        int clienteAL=0;
                        int carroAL=0;
                        while(true) {
                            printListCliente(listCliente, "Clientes cadastrados");
                            System.out.println();
                            if(clienteAL == -666){
        						System.out.print("\n  Tente novamente, Opção invalida");
        					}
                            System.out.print("\n  Escolha um locatário: ");
                            clienteAL = inputInt() - 1;
                            if((clienteAL >= 0) && (clienteAL < listCliente.size())) {
                                break;
                            }
      					    clienteAL = -666;
                        }

                        while(true) {
                            printListVeiculo(listVeiculo, "Listagem de veículos disponiveis", true);
                            System.out.println();
                            if(carroAL == -666){
        						System.out.print("\n  Tente novamente, Opção invalida");
        					}
                            System.out.print("\n  Escolha um carro: ");
                            carroAL = inputInt() - 1;
                            if ((carroAL >= 0) && (carroAL < listVeiculo.size())) {
                                break;
                            }
                            carroAL = -666;
                        }

                      Locacao alugado = new Locacao();
                      alugado.aluga(clienteAL,listVeiculo.get(carroAL));

                      while(true) {
                          clearConsole();
                          System.out.printf("\n  Locação de Veículos\n\n  Deseja adicionar aluguel: \n\n  1 - Sim\n  2 - Não\n");
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
                              double desconto = leitor.nextDouble();
                              while(true) {
                                try {
                                    System.out.printf("  Valor total do aluguel: %.2f\n  Digite o valor de desconto desejado(Desconto máximo 12 porcento): ",alugado.getValor());
                                } catch(InputMismatchException a) {
                                  System.out.print("\n  Tente novamente, digite apenas números");
                                  leitor.nextLine();
                                }
                                if (desconto < 0 || desconto > 12) {
                                  System.out.println("  Valor inválido!");
                                }
                                else break;
                              }
                              if (desconto != 0)alugado.setValor(alugado.getValor()-(alugado.getValor()*(desconto/100)));
                              listVeiculo.get(carroAL-1).setDisponivel(false);
                              listAlugado.add(alugado);
      						break;
      					} else if(op == 2) {
      						break;
      					}
      					op = -666;
                      }
                    }

                    break;
                case 4:
                    printListVeiculo(listVeiculo, "Listagem de veículos cadastrados", false);
                    pause("\n  Pressione enter para continuar");
                    break;
                case 5:
                    break;
                case 6:
                    printListVeiculo(listVeiculo, "Listagem de veículos disponiveis", true);
                    pause("\n  Pressione enter para continuar");
                    break;
                case 7:
                    printListCliente(listCliente, "Listagem de clientes");
                    pause("\n  Pressione enter para continuar");
                    break;
                case 8:
                    clearConsole();
                    System.exit(0);
                default:
                    op = -666; //opção invalida
            }
        }
    }

    static void pause(String mensagem){
        Scanner input = new Scanner(System.in);
        System.out.printf("\n  %s ", mensagem);
        input.nextLine();
    }

    static void clearConsole(){
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException e) {

        } catch (InterruptedException e) {

        }
    }

    static int inputInt(){
        Scanner input = new Scanner(System.in);
        int in = 0;
        try {
            in = input.nextInt();
        } catch (InputMismatchException a) {
            in = -666;
            input.nextLine();
        }
        return in;
    }

    static double inputDouble(){
        Scanner input = new Scanner(System.in);
        double in = 0;
        try {
            in = input.nextDouble();
        } catch (InputMismatchException a) {
            in = -666;
            input.nextLine();
        }
        return in;
    }

    static String inputString(int stringEnd){
        Scanner leitor = new Scanner(System.in);
        String string = new String();
        string = leitor.nextLine();
        if (string.length() > stringEnd){
            string = string.substring(0, stringEnd);
        }
        return string;
    }

    static boolean confirmacaoBoolean(String titulo, String opcao1, String opcao2){
        Scanner input = new Scanner(System.in);
        int in = 0;
        while(true){
            clearConsole();
            System.out.printf("\n  %s\n\n  1 - %s\n  2 - %s\n", titulo, opcao1, opcao2);
            if(in == -666){
                System.out.print("\n  Opção invalida, tente novamente");
            }
            System.out.print("\n  Escolha uma opcão: ");
            in = inputInt();
            if(in == 1){
                return true;
            }else if(in == 2){
                return false;
            }
            in = -666;
        }
    }

    static void printListCliente(ArrayList<Cliente> listCliente, String titulo){
		clearConsole();
        System.out.printf("\n  %s\n\n      Nome                                 Cpf              Idade  Contato", titulo);
		for(int x = 0; x < listCliente.size(); x++){
			System.out.printf("\n  %2d  ", x+1);
			System.out.printf("%-35s  %-15s   %-5d  %-30s", listCliente.get(x).getNome(), listCliente.get(x).getCpf(), listCliente.get(x).getIdade(), listCliente.get(x).getContato());
		}
	}

    static void printListVeiculo(ArrayList<Veiculo> listVeiculo, String titulo, boolean disponiveis){
        clearConsole();
        System.out.printf("\n  %s\n\n      Tipo   Descrição                                 Placa     Partida  Num. passageiros", titulo);
        for(int x = 0; x < listVeiculo.size(); x++){
            if(listVeiculo.get(x).isDisponivel() || !disponiveis){
                System.out.printf("\n  %2d  ", x+1);
                if (listVeiculo.get(x).isTipoVeiculo()){
                    System.out.printf("Carro  %-40s  %-8s           %2d", listVeiculo.get(x).getDescricaoVeiculo(), listVeiculo.get(x).getPlacaVeiculo(), listVeiculo.get(x).getCarroNumeroPassageiros());
                } else {
                    System.out.printf("Moto   %-40s  %-8s  ", listVeiculo.get(x).getDescricaoVeiculo(), listVeiculo.get(x).getPlacaVeiculo());
                    if (listVeiculo.get(x).isMotoPartidaEletrica()) {
                        System.out.printf("Com");
                    } else {
                        System.out.printf("Sem");
                    }
                }
            }
        }
    }

    static void cadastrarCliente(Cliente cliente) {
	    Scanner leitor = new Scanner(System.in);
		int in = 0;

		clearConsole();
		System.out.print("\n  Cadastro de cliente\n\n  Digite seu nome: ");
    	cliente.setNome(inputString(35));

		do{
			clearConsole();
			System.out.print("\n  Cadastro de cliente\n");
            if (in == -666){
                System.out.print("\n  Tente novamente, digite apenas números");
            }
            System.out.print("\n  Digite sua idade: ");
            in = inputInt();
		} while(in == -666);

        clearConsole();
		System.out.print("\n  Cadastro de cliente\n\n  Exemplo: 999.999.999-99\n\n  Digite seu cpf: ");
		cliente.setCpf(inputString(15));

		clearConsole();
		System.out.print("\n  Cadastro de cliente\n\n  Digite o contato: ");
		cliente.setContato(leitor.nextLine());
	}

    static void cadastrarVeiculo(Veiculo veiculo){
        Scanner leitor = new Scanner(System.in);
        int in = 0;

        if (!confirmacaoBoolean("Cadastro de veiculo", "Carro", "Moto")){
            veiculo.setTipoVeiculo(false);
        }

        while(true) {
            clearConsole();
            System.out.print("\n  Cadastro de veiculo\n");
            if(in == -666){
                System.out.print("\n  Tente novamente, Valor invalido");
            }
            System.out.print("\n  Digite o valor da diaria do veiculo: ");
            veiculo.setValorDiaria(inputDouble());
            if(veiculo.getValorDiaria() > 0.0) {
                    break;
            } else {
            in = -666;
            }
        }

        clearConsole();
        System.out.print("\n  Cadastro de veiculo\n\n  Digite a descrição do veiculo: ");
        veiculo.setDescricaoVeiculo(inputString(40));

        clearConsole();
        System.out.print("\n  Cadastro de veiculo\n\n  Exemplo: XXX-9999\n\n  Digite a placa do veiculo: ");
        veiculo.setPlacaVeiculo(inputString(8));

        in = 0;
        if(veiculo.isTipoVeiculo()) {
            while(true) {
                clearConsole();
                System.out.print("\n  Cadastro de veiculo\n");
                if(in == -666){
                    System.out.print("\n  Tente novamente, Valor invalido");
                }
                System.out.print("\n  Digite o numero de passageiros:");
                veiculo.setCarroNumeroPassageiros(inputInt());
                if(veiculo.getCarroNumeroPassageiros() > 0) {
                    break;
                }
                in = -666;
            }
        } else {
            if (!confirmacaoBoolean("Cadastro de veiculo\n\n  Possui partida eletrica", "Sim", "Não")){
                veiculo.setMotoPartidaEletrica(false);
            }
        }
    }
}
