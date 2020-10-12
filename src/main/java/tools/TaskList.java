package tools;

import functions.Task;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void addTask(Task task) {
        tasks.add(task);
    }

    public static void removeTask(int index) {
        tasks.remove(index);
    }

    public static int sizeOf() {
        return tasks.size();
    }

    public static Task getTask(int index) {
        return tasks.get(index);
    }
}
