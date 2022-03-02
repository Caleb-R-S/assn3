import java.util.LinkedList;

public class TaskQueue {
    // private Boolean isOpen = true;
    // private Boolean mutexLock = true;    
    private LinkedList<Task> list = new LinkedList<>();

    
    
    // public void closeForEditing() {
    //     this.isOpen = false;
    // }

    // public void releaseForEditing() {
    //     this.isOpen = true;
    // }

    // public Boolean checkForEditing() {
    //     return this.isOpen;
    // }

    public synchronized Task getNextTask() {
        return list.removeFirst();
    }

    // public Boolean checkMutex() {
    //     return this.mutexLock;
    // }

    // public void lockMutex() {
    //     this.mutexLock = false;
    // }

    // public void unlockMutex() {
    //     this.mutexLock = true;
    // }

    public synchronized void addNewTask(Task newTask) {
        list.add(newTask);
    }

    public synchronized Integer length() {
        return list.size();
    }
}
