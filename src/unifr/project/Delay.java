package unifr.project;

public class Delay implements Runnable {
    public Delay() {

    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
