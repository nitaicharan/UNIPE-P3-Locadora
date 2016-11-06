package locadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Veiculo {
		private boolean tipoVeiculo; // True = Carro False = Moto
		private double valorDiaria;
		private String descricaoVeiculo;
		private String placaVeiculo;
		private int carroNumeroPassageiros;
		private boolean motoPartidaEletrica;

		public boolean getTipoVeiculo() {
			return tipoVeiculo;
		}
		public double getValorDiaria() {
			return valorDiaria;
		}
		public String getDescricaoVeiculo() {
			return descricaoVeiculo;
		}
		public String getPlacaVeiculo() {
			return placaVeiculo;
		}
		public int carroNumeroPassageiros() {
			return carroNumeroPassageiros;
		}
	    public boolean motoPartidaEletrica() {
	        return motoPartidaEletrica;
	    }

		public void Cadastrar(){
			Scanner leitor = new Scanner(System.in);

			while(true) {
				int in = 0;
				try {
					System.out.print("\n  1 - Carro\n  2 - Moto\n\n  Escolha uma opção: ");
					in = leitor.nextInt();
					if((in != 1) && (in != 2)) {
						System.out.print("\n  Tente novamente, Opção invalida");
						continue;
					}
					break;
				} catch(InputMismatchException a) {
					System.out.print("\n  Tente novamente, digite apenas números");
					leitor.nextLine();
				}
				if (in == 1){
					this.tipoVeiculo = true;
				}
				else {
					this.tipoVeiculo = false;
				}
			}
			while(true) {
				try {
					System.out.print("\n  Digite o valor da diaria do veiculo: ");
					this.valorDiaria = leitor.nextDouble();
					if(this.valorDiaria <= 0.0) {
						System.out.print("\n  Tente novamente, Valor invalido");
						continue;
					}
					break;
				} catch(InputMismatchException a) {
					System.out.print("\n  Tente novamente, digite apenas números");
					leitor.nextLine();
				}
			}

			leitor.nextLine();
			System.out.print("\n  Digite a descrição do veiculo: ");
			this.descricaoVeiculo = leitor.nextLine();

			System.out.print("\n  Digite a placa do veiculo: ");
			this.placaVeiculo = leitor.nextLine();

			if(tipoVeiculo == true) {
				while(true) {
					try {
						System.out.print("\n  Digite o numero de passageiros:");
						this.carroNumeroPassageiros = leitor.nextInt();
						if(this.carroNumeroPassageiros <= 0) {
							System.out.print("\n  Tente novamente, Valor invalido");
							continue;
						}
						break;
					} catch(InputMismatchException a) {
						System.out.print("\n  Tente novamente, digite apenas números");
						leitor.nextLine();
					}
				}
			} else {
				int in = 0;
				while(true) {
					try {
						System.out.print("\n  Possui partida eletrica\n\n  1 - Sim\n  2 - Não\n\n  Escolha uma opção: ");
						in = leitor.nextInt();
						if((in != 1) && (in != 2)) {
							System.out.print("\n  Tente novamente, Opção invalida");
							continue;
						}
						break;
					} catch(InputMismatchException a) {
						System.out.print("\n  Tente novamente, digite apenas números");
						leitor.nextLine();
					}
					if (in == 1){
						this.motoPartidaEletrica = true;
					}
					else {
						this.motoPartidaEletrica = false;
					}
				}
			}
		}
}
