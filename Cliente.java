package locadora;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
	private String nome;
	private int idade;
	private String cpf;
	private String contato;

	/**
	* Returns value of nome
	* @return
	*/
	public String getNome() {return nome;}
	/**
	* Sets new value of nome
	* @param
	*/
	public void setNome(String nome) {this.nome = nome;}

	/**
	* Returns value of idade
	* @return
	*/
	public int getIdade() {return idade;}
	/**
	* Sets new value of idade
	* @param
	*/
	public void setIdade(int idade) {this.idade = idade;}

	/**
	* Returns value of cpf
	* @return
	*/
	public String getCpf() {return cpf;}
	/**
	* Sets new value of cpf
	* @param
	*/
	public void setCpf(String cpf) {this.cpf = cpf;}

	/**
	* Returns value of contato
	* @return
	*/
	public String getContato() {return contato;}
	/**
	* Sets new value of contato
	* @param
	*/
	public void setContato(String contato) {this.contato = contato;}

	static void printListCliente(ArrayList<Cliente> listCliente, String titulo){
		Console.clear();
        System.out.printf("\n  %s\n\n      Nome                                 Cpf               Idade  Contato", titulo);
		for(int x = 0; x < listCliente.size(); x++){
			System.out.printf("\n  %2d  ", x+1);
			System.out.printf("%-35s  %-15s   %5d  %-30s", listCliente.get(x).getNome(), listCliente.get(x).getCpf(), listCliente.get(x).getIdade(), listCliente.get(x).getContato());
		}
	}

	static void cadastrarCliente(Cliente cliente) {
		Console.clear();
		System.out.print("\n  Cadastro de cliente\n\n  Digite seu nome: ");
    	cliente.setNome(Input.inString(35));

		do{
			Console.clear();
			System.out.print("\n  Cadastro de cliente\n");
            if (cliente.getIdade() == -666){
                System.out.print("\n  Tente novamente, digite apenas números");
            }
            System.out.print("\n  Digite sua idade: ");
            cliente.setIdade(Input.inInt());
		} while(cliente.getIdade() == -666);

        Console.clear();
		System.out.print("\n  Cadastro de cliente\n\n  Exemplo: 999.999.999-99\n\n  Digite seu cpf: ");
		cliente.setCpf(Input.inString(15));

		Console.clear();
		System.out.print("\n  Cadastro de cliente\n\n  Digite o contato: ");
		cliente.setContato(Input.inString(50));
	}
}
