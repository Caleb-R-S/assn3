import java.util.HashMap;
public class ResultsTable {
    private Boolean isOpen = true;
    private HashMap<Long, String> table = new HashMap<>();

    public void work() {
        System.out.println("Hello World"+ this.isOpen);
    }

    public void closeForEditing() {
        this.isOpen = false;
    }

    public void releaseForEditing() {
        this.isOpen = true;
    }

    public Boolean checkForEditing() {
        return this.isOpen;
    }

    public void addNewDigit(Long key, String value) {
        this.table.put(key, value);
    }

    public HashMap<Long, String> returnTable() {
        return this.table;
    }
}
