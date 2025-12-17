import java.time.LocalDate;
import java.util.ArrayList;

public class TaskManager {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String title, LocalDate dueDate) {
        Task t = new Task(title, dueDate);
        tasks.add(t);
    }
        
    public void listTasks() {
        if (tasks.size() == 0) {
            System.out.println("タスクはありません");
            return;
        }
        tasks.forEach(t -> System.out.println(t));
    }


    public void deleteTask(int number) {
        int index = number - 1;
        if(index < 0 || index >= tasks.size()){
            throw new IndexOutOfBoundsException("存在しないタスク番号です");
        }
        tasks.remove(index);
    }

    public void completeTask(int number) {
        int index = number - 1;
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("存在しないタスク番号です");
        }
        tasks.get(index).markCompleted();
    }

    public int size() {
        return tasks.size();
    }
}
