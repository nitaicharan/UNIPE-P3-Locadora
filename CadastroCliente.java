package locadora;

import java.util.Scanner;

public class CadastroCliente  {

	String nome;
	int idade;
	int cpf;
	String rua;
	int contato;






	public void Cadastro(){




		System.out.println("Digite seu nome:");
		Scanner leitor = new Scanner(System.in);
		nome = leitor.next();

		System.out.println("Digite sua idade:");
		Scanner leitor2 = new Scanner(System.in);
		idade = leitor2.nextInt();

		System.out.println("Digite seu cpf:");
		Scanner leitor3 = new Scanner(System.in);
		cpf = leitor3.nextInt();

		System.out.println("Digite sua Rua"+"Rua ");
		Scanner leitor4 = new Scanner(System.in);
		rua = leitor4.next();

		System.out.println("Digite seu numero para contato:");
		Scanner leitor5 = new Scanner(System.in);
		contato = leitor5.nextInt();


	}





}
