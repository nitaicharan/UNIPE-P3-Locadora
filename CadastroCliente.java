package locadora;

import java.util.Scanner;

public class CadastroCliente  {

	private String nome;
	private int idade;
	private int cpf;
	private String contato;

	/**
	* Returns value of nome
	* @return
	*/
	public String getNome() {
		return nome;
	}

	/**
	* Sets new value of nome
	* @param
	*/
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	* Returns value of idade
	* @return
	*/
	public int getIdade() {
		return idade;
	}

	/**
	* Sets new value of idade
	* @param
	*/
	public void setIdade(int idade) {
		this.idade = idade;
	}

	/**
	* Returns value of cpf
	* @return
	*/
	public int getCpf() {
		return cpf;
	}

	/**
	* Sets new value of cpf
	* @param
	*/
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	/**
	* Returns value of contato
	* @return
	*/
	public String getContato() {
		return contato;
	}

	/**
	* Sets new value of contato
	* @param
	*/
	public void setContato(String contato) {
		this.contato = contato;
	}
}
