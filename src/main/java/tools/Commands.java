package tools;

import functions.Deadline;
import functions.Event;
import functions.Todo;

import java.io.IOException;

public class Commands {

    public static void todo(String desc) throws IOException {
        TaskList.addTask(new Todo(desc));
        Storage.save();
        Ui.addTaskMsg();
    }

    public static void deadline(String desc, String time) throws IOException {
        TaskList.addTask(new Deadline(desc, time));
        Storage.save();
        Ui.addTaskMsg();
    }

    public static void event(String desc, String time) throws IOException {
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

}
