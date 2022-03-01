import java.util.LinkedList;

public class TaskQueue {
    private Boolean isOpen = true;
    private LinkedList<Task> list = new LinkedList<>();

    public void closeForEditing() {
        this.isOpen = false;
    }

    public void releaseForEditing() {
        this.isOpen = true;
    }

    public Boolean checkForEditing() {
        return this.isOpen;
    }

    public Task getNextTeTask() {
        return list.removeFirst();
    }

    public void addNewTask(Task newTask) {
        list.add(newTask);
    }

    public Integer length() {
        return list.size();
    }
}
