package tools;

import functions.Deadline;
import functions.Event;
import functions.Task;
import functions.Todo;

import java.io.IOException;
import java.time.LocalDate;

public class Commands {

    public static void todo(String desc) throws IOException {
        TaskList.addTask(new Todo(desc));
        Storage.save();
        Ui.addTaskMsg();
    }

    public static void deadline(String desc, LocalDate time) throws IOException {
        TaskList.addTask(new Deadline(desc, time));
        Storage.save();
        Ui.addTaskMsg();
    }

    public static void event(String desc, LocalDate time) throws IOException {
        TaskList.addTask(new Event(desc, time));
        Storage.save();
        Ui.addTaskMsg();
    }

    public static void done(int num) throws IOException {
        TaskList.getTask(num - 1).isDone = true;
        Storage.save();
        Ui.doneTaskMsg(num);
    }

    public static void list() {
        Ui.listTaskMsg();
        for (int x = 0; x < TaskList.sizeOf(); x++) {
            System.out.printf("%d.%s\n", x + 1, TaskList.getTask(x));
        }
    }

    public static void delete(int num) throws IOException {
        Ui.deleteTaskMsg(num);
        TaskList.removeTask(num - 1);
        Storage.save();
    }

    /**
     * List all tasks with the given date by searching and comparing every task in TaskList
     * @param input raw input substring of index 5 and above from the user. Must be a valid date
     * in valid format or an exception will be thrown inside LocalDate.parse and will be
     * caught and handled in Duke main.
     */
    public static void listDate(String input) {
        Ui.listTaskMsg();
        LocalDate date = LocalDate.parse(input, Constants.format1);
        for (int i = 0; i < TaskList.sizeOf(); i++) {
            Task task = TaskList.getTask(i);
            LocalDate buffer = task.getDate();
            if (buffer == null) {
                continue;
            } else if (buffer.equals(date)) {
                System.out.printf("%d.%s\n", i + 1, TaskList.getTask(i));
            }
        }
    }

    /**
     * List all tasks containing the given keyword by searching and comparing the description of
     * every task in TaskList.
     * @param keyword raw input substring of index 5 and above from the user.
     */
    public static void find(String keyword) {
        Ui.listTaskMsg();
        for (int i = 0; i < TaskList.sizeOf(); i++) {
            Task task = TaskList.getTask(i);
            String buffer = task.getDescription();
            if (buffer.contains(keyword)) {
                System.out.printf("%d.%s\n", i + 1, TaskList.getTask(i));
            }
        }
    }
}
