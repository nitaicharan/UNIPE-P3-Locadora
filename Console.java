package locadora;

import java.io.IOException;
import java.util.Scanner;

public class Console{
    static void clear(){
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException e) {
            System.out.println("Error clearing terminal");
        } catch (InterruptedException e) {
            System.out.println("Error clearing terminal");
        }
    }

    static void pause(String mensagem, boolean clear){
        if(clear){
            Console.clear();
        }
        Scanner input = new Scanner(System.in);
        System.out.printf("\n  %s ", mensagem);
        input.nextLine();
    }
}
