public class TaskApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        while (true) {
            System.out.println("タスク管理システム");
            System.out.println("1: タスクを登録する");
            System.out.println("2: タスクを一覧表示する");
            System.out.println("3: タスクを削除する");
            System.out.println("4: タスクを完了にする");
            System.out.println("0: 終了");
            System.out.print("メニュー番号を入力してください: ");

            String line = input.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("半角数字で入力してください。");
                System.out.println();
                continue;
            }

            if (choice == 0) {
                System.out.println("終了");
                System.out.println("登録件数: " + manager.size() + "件");
                break;
            }

            switch (choice) {
                case 1:
                    // タスク登録
                    while (true) {
                        try {
                            System.out.print("タイトルを入力してください: ");
                            String title = input.nextLine();

                            System.out.print("期限を入力してください（例: 2025-11-01）: ");
                            String dueStr = input.nextLine();

                            LocalDate dueDate = LocalDate.parse(dueStr); // 不正なら例外
                            manager.addTask(title, dueDate);              // タイトル不正なら例外

                            System.out.println("登録しました。");
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("日付形式が不正です。例: 2025-11-01");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println();
                    break;

                case 2:
                    // 一覧表示（TaskManager側でforEachラムダ）
                    manager.listTasks();
                    System.out.println();
                    break;

                case 3:
                    // タスクを削除
                    while (true) {
                        try {
                            System.out.print("削除するタスク番号を入力してください: ");
                            int number = Integer.parseInt(input.nextLine());
                            manager.deleteTask(number);
                            System.out.println("削除しました。");
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("半角数字で入力してください。");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println();
                    break;

                case 4:
                    // タスクを完了
                    while (true) {
                        try {
                            System.out.print("完了にするタスク番号を入力してください: ");
                            int number = Integer.parseInt(input.nextLine());
                            manager.completeTask(number);
                            System.out.println("完了にしました。");
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("半角数字で入力してください。");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println();
                    break;

                default:
                    System.out.println("0〜4の番号を入力してください。");
                    System.out.println();
                    break;
            }
        }
        input.close();
    }
}
