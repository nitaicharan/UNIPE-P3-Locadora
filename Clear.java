package locadora;

import java.io.IOException;

public class Clear{
        public void clearConsole(){
            try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException e) {

        } catch (InterruptedException e) {

        }
    }
}
