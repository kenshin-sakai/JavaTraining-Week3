public class Task {
    private String title;
    private LocalDate dueDate;
    private boolean completed;

    public Task(String title, LocalDate dueDate) {
        if (title == null || title.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (dueDate == null) {
            throw new IllegalArgumentException();
        }

        this.title = title;
        this.dueDate = dueDate;
        this.completed = false;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public String toString() {
        // 一覧表示用の文字列（完了/未完了が分かるようにする）
        String label = completed ? "[✔完了]" : "[未完了]";
        return label + " " + title + " (期限: " + dueDate + ")";
    }
}
