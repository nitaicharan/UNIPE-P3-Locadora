package locadora;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Input{
    static double inDouble(){
        Scanner input = new Scanner(System.in);
        double in = 0;
        try {
            in = input.nextDouble();
        } catch (InputMismatchException a) {
            in = -666;
            input.nextLine();
        }
        return in;
    }

    static String inString(int stringEnd){
        Scanner leitor = new Scanner(System.in);
        String string = new String();
        string = leitor.nextLine();
        if (string.length() > stringEnd){
            string = string.substring(0, stringEnd);
        }
        return string;
    }

    static int inInt(){
        Scanner input = new Scanner(System.in);
        int in = 0;
        try {
            in = input.nextInt();
        } catch (InputMismatchException a) {
            in = -666;
            input.nextLine();
        }
        return in;
    }

    static boolean confirmacaoBoolean(String titulo, String opcao1, String opcao2, boolean clear){
        Scanner input = new Scanner(System.in);
        int in = 0;
        while(true){
            if (clear){
                Console.clear();
            }
            System.out.printf("\n  %s\n\n  1 - %s\n  2 - %s\n", titulo, opcao1, opcao2);
            if(in == -666){
                System.out.print("\n  Opção invalida, tente novamente");
            }
            System.out.print("\n  Escolha uma opcão: ");
            in = Input.inInt();
            if(in == 1){
                return true;
            }else if(in == 2){
                return false;
            }
            in = -666;
        }
    }
}
