package locadora;
import java.util.Scanner;

public class Locadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int op = 0;
        String firstOp;
        while (true) {
            System.out.print("1  --  Cadastrar Veículo\n");
            System.out.print("2  --  Cadastrar Cliente\n");
            System.out.print("3  --  Locação de Veículo\n");
            System.out.print("4  --  Listagem de veículos cadastrados\n");
            System.out.print("5  --  Listagem das locações\n");
            System.out.print("6  --  Listagem de veículos disponíveis\n");
            System.out.print("\n Escolha uma opcão: ");
            op = ler.nextInt();
            
            switch (op) {
                               
                case 1:
                        
                        break;
                case 2:
                        
                        break;
                case 3:
                        
                        break;
                case 4:
                        
                        break;
                case 5:
                        
                        break;
                case 6:
                        System.exit(0);
                default:
                        System.out.println("opção Invalida!");
        }
    }
        }

}
