public class WorkerThread implements Runnable{
    private TaskQueue remainingDigits;
    private ResultsTable results;

    WorkerThread(TaskQueue remainingDigits, ResultsTable results) {
        this.remainingDigits = remainingDigits;
        this.results = results;
    }


    public synchronized void run () {
        while(remainingDigits.length() > 0) {
            Task currentTask = remainingDigits.getNextTask();
            results.addNewDigit(currentTask.getDigitOfPi(), currentTask.completeTask());
            results.incrementTasksCompleted();
        }
    }
    public synchronized void CompleteTasks() {
        while(remainingDigits.length() > 0) {
            // if (remainingDigits.checkForEditing()) {
                // remainingDigits.closeForEditing();
                Task currentTask = remainingDigits.getNextTask();
                //CREATE THREAD HERE
                // String nextDigit = currentTask.completeTask();
                //ABOVE
                // Boolean hasBeenAdded = false;
                // while(!hasBeenAdded) {
                    // if (results.checkForEditing()) {
                        //Maybe start thread here
                        // results.closeForEditing();
                        results.addNewDigit(currentTask.getDigitOfPi(), currentTask.completeTask());
                        results.incrementTasksCompleted();
                        // results.releaseForEditing();
                        // hasBeenAdded = true;
                    // }
                // }
                // remainingDigits.releaseForEditing();
            // }
        }
    }


}
