package locadora;
import java.util.ArrayList;
import java.util.Scanner;

public class Veiculo {
	private boolean tipoVeiculo = true; // True = carro		False = moto
	private double valorDiaria;
	private String descricaoVeiculo;
	private String placaVeiculo;
	private int carroNumeroPassageiros;
	private boolean motoPartidaEletrica = true; // True = tem partida		False = não tem partida
	private boolean disponivel = true; // True = disponivel			False = não disponivel

	/**
	* Returns value of tipoVeiculo
	* @return
	*/
	public boolean isTipoVeiculo() {return tipoVeiculo;}
	/**
	* Sets new value of tipoVeiculo
	* @param
	*/
	public void setTipoVeiculo(boolean tipoVeiculo) {this.tipoVeiculo = tipoVeiculo;}

	/**
	* Returns value of valorDiaria
	* @return
	*/
	public double getValorDiaria() {return valorDiaria;}
	/**
	* Sets new value of valorDiaria
	* @param
	*/
	public void setValorDiaria(double valorDiaria) {this.valorDiaria = valorDiaria;}

	/**
	* Returns value of descricaoVeiculo
	* @return
	*/
	public String getDescricaoVeiculo() {return descricaoVeiculo;}
	/**
	* Sets new value of descricaoVeiculo
	* @param
	*/
	public void setDescricaoVeiculo(String descricaoVeiculo) {this.descricaoVeiculo = descricaoVeiculo;}

	/**
	* Returns value of placaVeiculo
	* @return
	*/
	public String getPlacaVeiculo() {return placaVeiculo;}
	/**
	* Sets new value of placaVeiculo
	* @param
	*/
	public void setPlacaVeiculo(String placaVeiculo) {this.placaVeiculo = placaVeiculo;}

	/**
	* Returns value of carroNumeroPassageiros
	* @return
	*/
	public int getCarroNumeroPassageiros() {return carroNumeroPassageiros;}
	/**
	* Sets new value of carroNumeroPassageiros
	* @param
	*/
	public void setCarroNumeroPassageiros(int carroNumeroPassageiros) {this.carroNumeroPassageiros = carroNumeroPassageiros;}

	/**
	* Returns value of motoPartidaEletrica
	* @return
	*/
	public boolean isMotoPartidaEletrica() {return motoPartidaEletrica;}
	/**
	* Sets new value of motoPartidaEletrica
	* @param
	*/
	public void setMotoPartidaEletrica(boolean motoPartidaEletrica) {this.motoPartidaEletrica = motoPartidaEletrica;}

	/**
	* Returns value of disponivel
	* @return
	*/
	public boolean isDisponivel() {return disponivel;}
	/**
	* Sets new value of disponivel
	* @param
	*/
	public void setDisponivel(boolean disponivel) {this.disponivel = disponivel;}

	static void printListVeiculo(ArrayList<Veiculo> listVeiculo, String titulo, boolean disponiveis){
        Console.clear();
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

    static void cadastrarVeiculo(Veiculo veiculo){
        Scanner leitor = new Scanner(System.in);
        int in = 0;

        if (!Input.confirmacaoBoolean("Cadastro de veiculo", "Carro", "Moto", true)){
            veiculo.setTipoVeiculo(false);
        }

        while(true) {
            Console.clear();
            System.out.print("\n  Cadastro de veiculo\n");
            if(in == -666){
                System.out.print("\n  Tente novamente, Valor invalido");
            }
            System.out.print("\n  Digite o valor da diaria do veiculo: ");
            veiculo.setValorDiaria(Input.inDouble());
            if(veiculo.getValorDiaria() > 0.0) {
                    break;
            } else {
            in = -666;
            }
        }

        Console.clear();
        System.out.print("\n  Cadastro de veiculo\n\n  Digite a descrição do veiculo: ");
        veiculo.setDescricaoVeiculo(Input.inString(40));

        Console.clear();
        System.out.print("\n  Cadastro de veiculo\n\n  Exemplo: XXX-9999\n\n  Digite a placa do veiculo: ");
        veiculo.setPlacaVeiculo(Input.inString(8));

        if(veiculo.isTipoVeiculo()) {
			do{
				Console.clear();
                System.out.print("\n  Cadastro de veiculo\n");
	            if (veiculo.getCarroNumeroPassageiros() == -666){
	                System.out.print("\n  Tente novamente, digite apenas números");
	            }
	            System.out.print("\n  Digite o numero de passageiros: ");
	            veiculo.setCarroNumeroPassageiros(Input.inInt());
				if(veiculo.getCarroNumeroPassageiros() < 0) {
                    veiculo.setCarroNumeroPassageiros(-666);
                }
			} while(veiculo.getCarroNumeroPassageiros() == -666);

        } else {
            if (!Input.confirmacaoBoolean("Cadastro de veiculo\n\n  Possui partida eletrica", "Sim", "Não", true)){
                veiculo.setMotoPartidaEletrica(false);
            }
        }
    }
}
