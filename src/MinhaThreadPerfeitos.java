
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class MinhaThreadPerfeitos implements Runnable {

    private final int limitePerfeitos;
    private final JTextArea jTextAreaPerfeitos;

    public MinhaThreadPerfeitos(int limitePerfeitos, JTextArea textArea) {
        jTextAreaPerfeitos = textArea;
        this.limitePerfeitos = limitePerfeitos;
    }

    @Override
    public void run() {
        //Calculando os números primos
        int somaDivisores;
        for (int i = 1; i <= this.limitePerfeitos; i++) {
            somaDivisores = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    somaDivisores = somaDivisores + j;
                }
            }
            if (somaDivisores == i) {
                this.jTextAreaPerfeitos.append("\n" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MinhaThreadPerfeitos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
