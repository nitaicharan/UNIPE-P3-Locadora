package locadora;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int op = 0;

        ArrayList<Cliente> listCliente = new ArrayList<Cliente>();
        ArrayList<Veiculo> listVeiculo = new ArrayList<Veiculo>();
        ArrayList<Locacao> listLocacao = new ArrayList<Locacao>();

        while(true) {
            Console.clear();
            System.out.print("\n  Locadora de veiculos\n\n  1 - Cadastrar veiculo\n  2 - Cadastrar cliente\n  3 - Locação de veiculo\n  4 - Listagem de veiculos cadastrados\n  5 - Listagem das locações\n  6 - Listagem de veiculos disponíveis\n  7 - Listagem de cliente\n  8 - Sair\n");
            if(op == -666){
                System.out.print("\n  Opção invalida!");
            }
            System.out.print("\n  Escolha uma opcão: ");
            op = Input.inInt();

            switch (op) {
                case 1:
                    Veiculo veiculo = new Veiculo();
                    Veiculo.cadastrarVeiculo(veiculo);
                    if(Input.confirmacaoBoolean("Cadastro de veiculo", "Sim", "Não", true)){
                        listVeiculo.add(veiculo);
                    }
                    break;
                case 2:
                    Cliente cliente = new Cliente();
                    Cliente.cadastrarCliente(cliente);
                    if(Input.confirmacaoBoolean("Cadastro de cliente", "Sim", "Não", true)){
                        listCliente.add(cliente);
                    }
                    break;
                case 3:
                    Locacao locacao = new Locacao();
                    if (Locacao.alugar(locacao, listCliente, listVeiculo)){
                        Console.clear();
                        System.out.println("\n  Locação de veiculo\n");
                        Locacao.printLocacao(locacao, listCliente.get(locacao.getCliente()), listVeiculo.get(locacao.getVeiculo()));
                        if(Input.confirmacaoBoolean("Deseja confirmar a locacao", "Sim", "Não", false)){
                            listVeiculo.get(locacao.getVeiculo()).setDisponivel(false);
                            listLocacao.add(locacao);
                        }
                    }
                    break;
                case 4:
                    if (listVeiculo.isEmpty()){
                        Console.pause("Locação de veiculo\n\n  Nem um veiculo cadastrado\n\n  Pressione enter para voltar", false);
                    } else {
                        Veiculo.printListVeiculo(listVeiculo, "Listagem de veículos cadastrados", false);
                        Console.pause("\n  Pressione enter para continuar", false);
                    }
                    break;
                case 5:
                    if (listLocacao.isEmpty()){
                        Console.pause("Locação de veiculo\n\n Nenhuma locacao registrada\n\n  Pressione enter para voltar", true);
                    } else {
                        Locacao.printListLocacao(listLocacao, listCliente, listVeiculo, "Listagem locações registradas");
                        Console.pause("\n  Pressione enter para continuar", false);
                    }
                    break;
                case 6:
                    if (listVeiculo.isEmpty()){
                        Console.pause("Locação de veiculo\n\n  Nem um veiculo cadastrado\n\n  Pressione enter para voltar", false);
                    } else {
                        Veiculo.printListVeiculo(listVeiculo, "Listagem de veículos disponiveis", true);
                        Console.pause("\n  Pressione enter para continuar", false);
                    }
                    break;
                case 7:
                    if (listCliente.isEmpty()){
                        Console.pause("Listagem de clientes\n\n  Nem um cliente cadastrado\n\n  Pressione enter para voltar", true);
                    } else {
                        Cliente.printListCliente(listCliente, "Listagem de clientes");
                        Console.pause("\n  Pressione enter para continuar", false);
                    }
                    break;
                case 8:
                    Console.clear();
                    System.exit(0);
                default:
                    op = -666; //opção invalida
            }
        }
    }
}
