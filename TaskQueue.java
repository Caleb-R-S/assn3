import java.util.LinkedList;

public class TaskQueue {   
    private LinkedList<Task> list = new LinkedList<>();
    
    public synchronized Task getNextTask() {
        return list.removeFirst();
    }

    public synchronized void addNewTask(Task newTask) {
        list.add(newTask);
    }

    public synchronized Integer length() {
        return list.size();
    }
}
