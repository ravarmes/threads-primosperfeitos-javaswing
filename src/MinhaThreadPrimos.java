
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class MinhaThreadPrimos implements Runnable {

    private final int limitePrimos;
    private final JTextArea jTextAreaPrimos;

    public MinhaThreadPrimos(int limitePrimos, JTextArea textArea) {
        jTextAreaPrimos = textArea;
        this.limitePrimos = limitePrimos;
    }

    @Override
    public void run() {
        //Calculando os números primos
        int qtdDivisores;
        for (int i = 1; i <= this.limitePrimos; i++) {
            qtdDivisores = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    qtdDivisores++;
                }
            }
            if (qtdDivisores == 2) {
                this.jTextAreaPrimos.append("\n" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MinhaThreadPrimos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
