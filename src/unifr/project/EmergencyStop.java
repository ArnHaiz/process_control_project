package unifr.project;

import java.util.ArrayList;

public class EmergencyStop implements Runnable {
    private boolean emergency;
    private final ArrayList<Thread> threads;
    private boolean areJoined;

    public EmergencyStop(ArrayList<Thread> threads) {
        emergency = false;
        areJoined = false;
        this.threads = threads;
    }

    public void updateEmergency() {
        emergency = !emergency;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (emergency && !areJoined) {
                    areJoined = true;
                    for (Thread thread : threads) {
                        thread.join();
                    }
                } else {
                    areJoined = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
