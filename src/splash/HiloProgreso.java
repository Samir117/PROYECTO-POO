package splash;

import javax.swing.JProgressBar;

public class HiloProgreso extends Thread {

    JProgressBar progreso;

    public HiloProgreso(JProgressBar progreso1) {
        super();
        this.progreso = progreso1;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            progreso.setValue(i);
            pausa(10);
        }

    }

    public void pausa(int mlSeg) {
        try {
            Thread.sleep(mlSeg);
        } catch (InterruptedException e) {
        }
    }
}
