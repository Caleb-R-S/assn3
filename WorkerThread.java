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
            Integer count = results.getTasksCompleted();
            if (count % 10 == 0) {
                System.out.print(".");
            }
            if (count % 250 == 0) {
                System.out.print("\n");
            }
        }
    }
}
