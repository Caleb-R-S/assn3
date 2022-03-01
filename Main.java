import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ResultsTable results = new ResultsTable();
        TaskQueue remainingDigits = new TaskQueue();
        ArrayList<Long> oneThousandLongs = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            oneThousandLongs.add(Integer.toUnsignedLong(i));
            System.out.println(i);
        }

        java.util.Collections.shuffle(oneThousandLongs);

        for (Long value : oneThousandLongs) {
            Task newTask = new Task(value);
            if (remainingDigits.checkForEditing()) {
                remainingDigits.closeForEditing();
                remainingDigits.addNewTask(newTask);
                remainingDigits.releaseForEditing();
            }
        }


        while(remainingDigits.length() > 0) {
            if (remainingDigits.checkForEditing()) {
                remainingDigits.closeForEditing();
                Task currentTask = remainingDigits.getNextTeTask();
                //CREATE THREAD HERE
                // String nextDigit = currentTask.completeTask();
                //ABOVE
                Boolean hasBeenAdded = false;
                while(!hasBeenAdded) {
                    if (results.checkForEditing()) {
                        //Maybe start thread here
                        results.closeForEditing();
                        results.addNewDigit(currentTask.getDigitOfPi(), currentTask.completeTask());
                        results.releaseForEditing();
                    }
                }
                remainingDigits.releaseForEditing();
            }
        }
        System.out.print("3.");
        HashMap<Long, String> finalTable = results.returnTable();
        for (String numAtDecimal : sor)
    }
}
