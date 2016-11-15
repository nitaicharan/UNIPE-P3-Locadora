package locadora;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Locacao{
    private int veiculo = -1;
    private int cliente = -1;
    private double valor = -1;//valor locação
    private double desconto = -1;
    private int dias;
    private String data;
    private double seguro = 0;

    /**
    * Returns value of veiculo
    * @return
    */
    public int getVeiculo() {return veiculo;}
    /**
    * Sets new value of veiculo
    * @param
    */
    public void setVeiculo(int veiculo) {this.veiculo = veiculo;}

    /**
    * Returns value of cliente
    * @return
    */
    public int getCliente() {return cliente;}
    /**
    * Sets new value of cliente
    * @param
    */
    public void setCliente(int cliente) {this.cliente = cliente;}

    /**
    * Returns value of valor
    * @return
    */
    public double getValor() {return valor;}
    /**
    * Sets new value of valor
    * @param
    */
    public void setValor(double valor) {this.valor = valor;}

    /**
    * Returns value of desconto
    * @return
    */
    public double getDesconto() {return desconto;}
    /**
    * Sets new value of desconto
    * @param
    */
    public void setDesconto(double desconto) {this.desconto = desconto;}

    /**
    * Returns value of dias
    * @return
    */
    public int getDias() {return dias;}
    /**
    * Sets new value of dias
    * @param
    */
    public void setDias(int dias) {this.dias = dias;}

    /**
    * Returns value of data
    * @return
    */
    public String getData() {return data;}
    /**
    * Sets new value of data
    * @param
    */
    public void setData(String data) {this.data = data;}

    /**
    * Returns value of seguro
    * @return
    */
    public double getSeguro() {return seguro;}
    /**
    * Sets new value of seguro
    * @param
    */
    public void setSeguro(double seguro) {this.seguro = seguro;}

    static void printLocacao(Locacao locacao, Cliente cliente, Veiculo veiculo){
        System.out.printf("  Cliente: %s\n  Veiculo: %s\n  Valor total: %7.2f   Dias: %3d\n", cliente.getNome(), veiculo.getDescricaoVeiculo(), locacao.getValor(), locacao.getDias());
    }

    static void printListLocacao(ArrayList<Locacao> listLocacao, ArrayList<Cliente> listCliente, ArrayList<Veiculo> listVeiculo, String titulo){
        Console.clear();
        System.out.printf("\n  %s\n\n       Cliente                              Veiculo                                   Valor     Dias", titulo);
        for(int x = 0; x <listLocacao.size(); x++){
            System.out.printf("\n  %3d  %-35s  %-40s  %8.2f  %4d", x+1, listCliente.get(listLocacao.get(x).getCliente()).getNome(), listVeiculo.get(listLocacao.get(x).getVeiculo()).getDescricaoVeiculo(), listLocacao.get(x).getValor(), listLocacao.get(x).getDias());
        }
    }

    static boolean alugar(Locacao locacao, ArrayList<Cliente> listCliente, ArrayList<Veiculo> listVeiculo){
        if (listCliente.isEmpty()){
            Console.pause("Locação de veículo\n\n  Nem um cliente cadastrado\n\n  Pressione enter para voltar", true);
            return false;
        } else if (listVeiculo.isEmpty()){
            Console.pause("Locação de veículo\n\n  Nem um veiculo cadastrado\n\n  Pressione enter para voltar", true);
            return false;
        } else {
            do {
                Cliente.printListCliente(listCliente, "Clientes cadastrados");
                System.out.println();
                if(locacao.getCliente() == -666){
                    System.out.print("\n  Tente novamente, Opção invalida");
                }
                System.out.print("\n  Escolha um cliente: ");
                locacao.setCliente(Input.inInt() - 1);
                if((locacao.getCliente() < 0) || (locacao.getCliente() >= listCliente.size())) {
                    locacao.setCliente(-666);
                }
            } while(locacao.getCliente() == -666);

            do {
                Veiculo.printListVeiculo(listVeiculo, "Listagem de veículos disponiveis", true);
                System.out.println();
                if(locacao.getVeiculo() == -666){
                    System.out.print("\n  Tente novamente, Opção invalida");
                }
                System.out.print("\n  Escolha um veiculo: ");
                locacao.setVeiculo(Input.inInt() - 1);
                if ((locacao.getVeiculo() < 0) || (locacao.getVeiculo() >= listVeiculo.size())) {
                    locacao.setVeiculo(-666);
                }
            } while(locacao.getVeiculo() == -666);

            do {
                Console.clear();
                System.out.print("\n  Locação de veiculo\n\n  Quantidade de dias da locação\n");
                if(locacao.getVeiculo() == -666){
                    System.out.print("\n  Tente novamente, Quantidade invalida");
                }
                System.out.print("\n  Digite a quantidade de dias: ");
                locacao.setDias(Input.inInt());
                if (locacao.getDias() <= 0){
                    locacao.setDias(-666);
                }
            } while (locacao.getDias() == -666);

            if(Input.confirmacaoBoolean("Locação de veiculos\n\n  Locação com seguro", "Sim", "Não", true)){
                if (listVeiculo.get(locacao.getVeiculo()).isTipoVeiculo()) {
                    locacao.setSeguro(0.05 * listVeiculo.get(locacao.getVeiculo()).getValorDiaria() * (1 + listVeiculo.get(locacao.getVeiculo()).getCarroNumeroPassageiros()/20));
                } else {
                    locacao.setSeguro(0.09 * listVeiculo.get(locacao.getVeiculo()).getValorDiaria());
                }
            }

            locacao.setValor((listVeiculo.get(locacao.getVeiculo()).getValorDiaria() * locacao.getDias()) + locacao.getSeguro());

            do {
                Console.clear();
                System.out.printf("\n  Locação de veiculo\n\n  Valor total da locação: %.2f\n", locacao.getValor());
                if (locacao.getDesconto() == -666) {
                    System.out.print("\n  Tente novamente, Desconto invalido");
                }
                System.out.print("\n  Digite o valor de desconto desejado(Desconto máximo 12 porcento): ");
                locacao.setDesconto(Input.inDouble());
                if ((locacao.getDesconto() < 0) || (locacao.getDesconto() > 12)){
                    locacao.setDesconto(-666);
                }
            } while (locacao.getDesconto() == -666);

            if (locacao.getDesconto() != 0){
                locacao.setValor(locacao.getValor()-(locacao.getValor()*(locacao.getDesconto()/100)));
            }
        return true;
        }
    }
}
