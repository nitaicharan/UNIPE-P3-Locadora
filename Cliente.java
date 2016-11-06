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
	public int getIdade() {
		return idade;
	}
	public int getCpf() {
		return cpf;
	}
	public String getContato() {
		return contato;
	}

	public void Cadastrar() {
	    Scanner leitor = new Scanner(System.in);

		System.out.print("\n  Digite seu nome: ");
		this.nome = leitor.nextLine();

		while(true) {
			try {
				System.out.print("\n  Digite sua idade: ");
				this.idade = leitor.nextInt();
				break;
			} catch(InputMismatchException a) {
				System.out.print("\n  Tente novamente, digite apenas números");
				leitor.nextLine();
			}
		}

		while(true) {
			try {
			  	System.out.print("\n  Digite seu cpf: ");
				this.cpf = leitor.nextInt();
				break;
			} catch(InputMismatchException b) {
				System.out.print("\n  Tente novamente, digite apenas números");
				leitor.nextLine();
			}
		}

		System.out.print("\n  Digite o contato: ");
		leitor.nextLine();
		this.contato = leitor.nextLine();
	}
}
