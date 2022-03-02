import java.util.HashMap;
public class ResultsTable {
    // private Boolean isOpen = true;
    // private Boolean mutexLock = true;
    private int tasksCompleted = 0;
    private HashMap<Long, String> table = new HashMap<>();


    // public void closeForEditing() {
    //     this.isOpen = false;
    // }

    // public void releaseForEditing() {
    //     this.isOpen = true;
    // }

    // public Boolean checkForEditing() {
    //     return this.isOpen;
    // }

    // public Boolean checkMutex() {
    //     return this.mutexLock;
    // }

    // public void lockMutex() {
    //     this.mutexLock = false;
    // }

    // public void unlockMutex() {
    //     this.mutexLock = true;
    // }

    public synchronized void addNewDigit(Long key, String value) {
        this.table.put(key, value);
    }

    public HashMap<Long, String> returnTable() {
        return this.table;
    }

    public synchronized void incrementTasksCompleted() {
        tasksCompleted ++;
    }

    public synchronized Integer getTasksCompleted() {
        return tasksCompleted;
    }
}
