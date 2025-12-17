import java.time.LocalDate;

public class Task {
    private String title;
    private LocalDate dueDate;
    private boolean completed;

    public Task(String title, LocalDate dueDate) {
        if (title == null || title.length() == 0) {
            throw new IllegalArgumentException("タイトルが空です");
        }
        if (dueDate == null) {
            throw new IllegalArgumentException("期限が不正です");
        }

        this.title = title;
        this.dueDate = dueDate;
        this.completed = false;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public String toString() {
        String label = completed ? "[✔完了]" : "[未完了]";
        return label + " " + title + " (期限: " + dueDate + ")";
    }
}
