package locadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Veiculo {
		private boolean tipoVeiculo = true; // True = Carro		False = Moto
		private double valorDiaria;
		private String descricaoVeiculo;
		private String placaVeiculo;
		private int carroNumeroPassageiros;
		private boolean motoPartidaEletrica = true; // True = tem partida		False = não tem partida
		private boolean disponivel = true;

		public boolean isTipoVeiculo() {
			return tipoVeiculo;
		}
		public void setTipoVeiculo(boolean tipoVeiculo) {
			this.tipoVeiculo = tipoVeiculo;
		}

		public double getValorDiaria() {
			return valorDiaria;
		}
		public void setValorDiaria(double valorDiaria) {
			this.valorDiaria = valorDiaria;
		}

		public String getDescricaoVeiculo() {
			return descricaoVeiculo;
		}
		public void setDescricaoVeiculo(String descricaoVeiculo) {
			this.descricaoVeiculo = descricaoVeiculo;
		}

		public String getPlacaVeiculo() {
			return placaVeiculo;
		}
		public void setPlacaVeiculo(String placaVeiculo) {
			this.placaVeiculo = placaVeiculo;
		}

		public int getCarroNumeroPassageiros() {
			return carroNumeroPassageiros;
		}
		public void setCarroNumeroPassageiros(int carroNumeroPassageiros) {
			this.carroNumeroPassageiros = carroNumeroPassageiros;
		}

		public boolean isMotoPartidaEletrica() {
			return motoPartidaEletrica;
		}
		public void setMotoPartidaEletrica(boolean motoPartidaEletrica) {
			this.motoPartidaEletrica = motoPartidaEletrica;
		}

		public boolean isDisponivel() {
			return disponivel;
		}
		public void setDisponivel(boolean disponivel) {
			this.disponivel = disponivel;
		}

		public void Cadastrar(){
			Scanner leitor = new Scanner(System.in);
			int in = 0;

			while(true) {
				new Clear().clearConsole();
				try {
					System.out.print("\n  Cadastro de veiculo\n\n  1 - Carro\n  2 - Moto\n");
					if(in == -666){
						System.out.print("\n  Tente novamente, Opção invalida");
					}
					System.out.print("\n  Escolha uma opção: ");
					in = leitor.nextInt();
					if(in == 1) {
						break;
					} else if (in == 2) {
						this.tipoVeiculo = false;
						break;
					}
					in = -666;
				} catch(InputMismatchException a) {
					in = -666;
					leitor.nextLine();
				}
			}
			while(true) {
				new Clear().clearConsole();
				System.out.print("\n  Cadastro de veiculo\n");
				try {
					if(in == -666){
						System.out.print("\n  Tente novamente, Valor invalido");
					}
					System.out.print("\n  Digite o valor da diaria do veiculo: ");
					this.valorDiaria = leitor.nextDouble();
					if(this.valorDiaria > 0.0) {
						break;
					}
					in = -666;
				} catch(InputMismatchException a) {
					in = -666;
					leitor.nextLine();
				}
			}

			in = 1;
			leitor.nextLine();
			new Clear().clearConsole();
			System.out.print("\n  Cadastro de veiculo\n\n  Digite a descrição do veiculo: ");
			this.descricaoVeiculo = leitor.nextLine();

			new Clear().clearConsole();
			System.out.print("\n  Cadastro de veiculo\n\n  Digite a placa do veiculo: ");
			this.placaVeiculo = leitor.nextLine();

			if(this.tipoVeiculo) {
				while(true) {
					new Clear().clearConsole();
					System.out.print("\n  Cadastro de veiculo\n");
					try {
						if(in == -666){
							System.out.print("\n  Tente novamente, Valor invalido");
						}
						System.out.print("\n  Digite o numero de passageiros:");
						this.carroNumeroPassageiros = leitor.nextInt();
						if(this.carroNumeroPassageiros > 0) {
							break;
						}
						in = -666;
					} catch(InputMismatchException a) {
						in = -666;
						leitor.nextLine();
					}
				}
			} else {
				while(true) {
					new Clear().clearConsole();
					try {
						System.out.print("\n  Possui partida eletrica\n\n  1 - Sim\n  2 - Não\n\n  ");
						if(in == -666){
							System.out.print("\n  Tente novamente, Valor invalido");
						}
						System.out.print("Escolha uma opção: ");
						in = leitor.nextInt();
						if((in == 1) || (in == 2)) {
							break;
						}
						in = -666;
					} catch(InputMismatchException a) {
						in = -666;
						leitor.nextLine();
					}
					if (in == 2){
						this.motoPartidaEletrica = false;
					}
				}
			}
		}
}
