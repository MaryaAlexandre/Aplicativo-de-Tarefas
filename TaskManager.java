import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void markTaskAsCompleted(int index) {
        tasks.get(index).markAsCompleted();
    }

    public void removeTask(int index) {
        tasks.remove(index);
    }
}
