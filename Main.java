import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        ResultsTable results = new ResultsTable();
        TaskQueue remainingDigits = new TaskQueue();
        ArrayList<Long> oneThousandLongs = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            oneThousandLongs.add(Integer.toUnsignedLong(i));
        }

        java.util.Collections.shuffle(oneThousandLongs);

        for (Long value : oneThousandLongs) {
            Task newTask = new Task(value);
            // if (remainingDigits.checkForEditing()) {
                // remainingDigits.closeForEditing();
            remainingDigits.addNewTask(newTask);
                // remainingDigits.releaseForEditing();
            // }
        }

        int totalNumberOfcores = Runtime.getRuntime().availableProcessors();
        Thread[] allThreads = new Thread[totalNumberOfcores];
        for (int i = 0; i < totalNumberOfcores; i++) {
            WorkerThread nextWorkerThread = new WorkerThread(remainingDigits, results);
            Thread thread = new Thread(nextWorkerThread, "Thread" + i);
            allThreads[i] = thread;
            thread.start();
        }
    
        int counter = 0;
        while(counter != totalNumberOfcores) {
            counter = 0;
            for (Thread currentThread : allThreads) {
                if (!currentThread.isAlive()) {
                    counter ++;
                }
            }
        }

        System.out.println();
        System.out.print("3.");
        HashMap<Long, String> finalTable = results.returnTable();
        for (Long i = 1l; i <= 1000; i++ ) {
            System.out.print(finalTable.get(i));
        }
        Long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("Total time was: " + (endTime - startTime) / 1000 + " seconds");
        
    }
}
