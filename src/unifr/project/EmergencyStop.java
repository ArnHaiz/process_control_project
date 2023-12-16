package unifr.project;

import java.util.ArrayList;

/**
 * Class handling the stopping of the car in case of an emergency.
 *
 * @author Arnaud Haizmann (20-806-436)
 */
public class EmergencyStop implements Runnable {
    private boolean emergency;
    private final ArrayList<Thread> threads;
    private boolean areJoined;

    /**
     * public constructor of the class
     * @param threads the list of threads the emergency handles
     */
    public EmergencyStop(ArrayList<Thread> threads) {
        emergency = false;
        areJoined = false;
        this.threads = threads;
    }

    /**
     * the local state of the emergency
     */
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
                        thread.interrupt();
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
