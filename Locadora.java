/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora;

import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Locadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
int op;
String firstOp;
while (true) {
    
    
    
    System.out.println("");
	firstOp = JOptionPane.showInputDialog(
                                "Selecione uma opção: \n\n"+
                                "1  --  Cadastrar Veículo\n"+
				"2  --  Cadastrar Cliente\n"+
                                "3  --  Locação de Veículo\n"+
                                "4  --  Listagem de veículos cadastrados\n"+
                                "5  --  Listagem das locações\n"+
				"6  --  Listagem de veículos disponíveis\n");
                                
	op = Integer.parseInt(firstOp);
	switch (op) {
		case 1:
			//chamar método para cadastrar cliente
			break;
		case 2:
			//chamar método para cadastrar cliente
			break;
		case 3:
			//chamar método para cadastrar cliente
			break;
		case 4:
			//chamar método....
			break;
		case 5:
			//chamar método para cadastrar cliente
			break;
		case 6:
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null,op + " é uma opção Invalida!", "ERRO",JOptionPane.ERROR_MESSAGE );
	}
}
    }
    
}
