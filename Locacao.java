package locadora;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Locacao{
  private int veiculo;
  private int cliente;
  private double valor;
  private double disconto;
  private int dias;
  private String data;
  private boolean seguro=true;




	/**
	* Returns value of veiculo
	* @return
	*/
	public int getVeiculo() {
		return veiculo;
	}

	/**
	* Sets new value of veiculo
	* @param
	*/
	public void setVeiculo(int veiculo) {
		this.veiculo = veiculo;
	}

	/**
	* Returns value of cliente
	* @return
	*/
	public int getCliente() {
		return cliente;
	}

	/**
	* Sets new value of cliente
	* @param
	*/
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	/**
	* Returns value of valor
	* @return
	*/
	public double getValor() {
		return valor;
	}

	/**
	* Sets new value of valor
	* @param
	*/
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	* Returns value of disconto
	* @return
	*/
	public double getDisconto() {
		return disconto;
	}

	/**
	* Sets new value of disconto
	* @param
	*/
	public void setDisconto(double disconto) {
		this.disconto = disconto;
	}

	/**
	* Returns value of dias
	* @return
	*/
	public int getDias() {
		return dias;
	}

	/**
	* Sets new value of dias
	* @param
	*/
	public void setDias(int dias) {
		this.dias = dias;
	}

	/**
	* Returns value of data
	* @return
	*/
	public String getData() {
		return data;
	}

	/**
	* Sets new value of data
	* @param
	*/
	public void setData(String data) {
		this.data = data;
	}

	/**
	* Returns value of seguro
	* @return
	*/
	public boolean isSeguro() {
		return seguro;
	}

	/**
	* Sets new value of seguro
	* @param
	*/
	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

  public void aluga(){
    Scanner leitor = new Scanner(System.in);
    new Clear().clearConsole();

    while(true) {
        new Clear().clearConsole();
        try {
            System.out.print("\n  Cadastro Cliente\n\n  Número de dias da locação: ");
            this.dias = leitor.nextInt();
            if (this.dias < 1){
                System.out.print("\n\n  Favor digite um número de dias válido!!");
                leitor.nextLine();
                continue;
            }
        } catch(InputMismatchException a) {
            System.out.println("  Favor entre com números!!");
            leitor.nextLine();
            continue;
        }
        System.out.println("  Data da alocação: ");
        this.data = leitor.nextLine();
        break;
    }


    while (true){
        System.out.print("  Alocação com Seguro?(S/N): ");
        String op = leitor.nextLine();
        if(op.length() > 1){
            System.out.println("  Favor entre com UMA letra!!");
            leitor.nextLine();
            continue;
        }
        else {
            if (op.charAt(0)=='N' || op.charAt(0)=='n') {
                this.seguro = true;
                break;
            }
            else if (op.charAt(0)=='S' || op.charAt(0)=='s') break;

            System.out.println("  Favor entre com S ou N!!");
            leitor.nextLine();
        }
    }

  }
}
