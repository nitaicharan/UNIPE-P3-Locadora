package locadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {

	private String nome;
	private int idade;
	private int cpf;
	private String contato;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}

	public void Cadastrar() {
	    Scanner leitor = new Scanner(System.in);
		int in = 0;

		new Clear().clearConsole();
		System.out.print("\n  Cadastro Cliente\n\n  Digite seu nome: ");
		this.nome = leitor.nextLine();

		while(true) {
			new Clear().clearConsole();
			System.out.print("\n  Cadastro Cliente");
			try {
				if (in == -666){
					System.out.print("\n\n  Tente novamente, digite apenas números");
				}
				System.out.print("\n\n  Digite sua idade: ");
				this.idade = leitor.nextInt();
				in = 0;
				break;
			} catch(InputMismatchException a) {
				in = -666;
				leitor.nextLine();
			}
		}

		while(true) {
			new Clear().clearConsole();
			System.out.print("\n  Cadastro Cliente\n");
			try {
				if (in == -666){
					System.out.print("\n  Tente novamente, digite apenas números\n");
				}
			  	System.out.print("\n  Digite seu cpf: ");
				this.cpf = leitor.nextInt();
				in = 0;
				break;
			} catch(InputMismatchException b) {
				in = -666;
				leitor.nextLine();
			}
		}

		new Clear().clearConsole();
		System.out.print("\n  Cadastro Cliente\n");
		leitor.nextLine();
		System.out.print("\n  Digite o contato: ");
		this.contato = leitor.nextLine();
	}
}
