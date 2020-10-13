package tools;

import functions.Deadline;
import functions.Event;
import functions.Todo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

public class Storage {

    private static String filepath;
    private static String dir_path;

    public static void setFilepath(String file, String directory) {
        filepath = file;
        dir_path = directory;
    }

    public static void createFilepath() throws IOException {
        if (!Files.exists(Paths.get(dir_path))) {
            Files.createDirectory(Paths.get(dir_path));
        }
        if (!Files.exists(Paths.get(filepath))) {
            Files.createFile(Paths.get(filepath));
        }
    }

    public static void save() throws IOException {

        createFilepath();
        StringBuilder str = new StringBuilder();
        for (int x = 0; x < TaskList.sizeOf(); x++) {
            str.append(TaskList.getTask(x).toSave() + System.lineSeparator());
        }
        FileWriter fw = new FileWriter(filepath);
        fw.write(String.valueOf(str));
        fw.close();
    }

    public static void load() throws IOException {

        createFilepath();
        File f = new File(filepath);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String str = s.nextLine();
            String[] part = str.split("~&@#%");
            if (part[0].equals("[T][y]")) {
                TaskList.addTask(new Todo(part[1]));
                TaskList.getTask(TaskList.sizeOf() - 1).isDone = true;
            } else if (part[0].equals("[T][n]")) {
                TaskList.addTask(new Todo(part[1]));
                TaskList.getTask(TaskList.sizeOf() - 1).isDone = false;
            } else if (part[0].equals("[D][y]")) {
                TaskList.addTask(new Deadline(part[1], LocalDate.parse(part[2], Constants.format2)));
                TaskList.getTask(TaskList.sizeOf() - 1).isDone = true;
            } else if (part[0].equals("[D][n]")) {
                TaskList.addTask(new Deadline(part[1], LocalDate.parse(part[2], Constants.format2)));
                TaskList.getTask(TaskList.sizeOf() - 1).isDone = false;
            } else if (part[0].equals("[E][y]")) {
                TaskList.addTask(new Event(part[1], LocalDate.parse(part[2], Constants.format2)));
                TaskList.getTask(TaskList.sizeOf() - 1).isDone = true;
            } else if (part[0].equals("[E][n]")) {
                TaskList.addTask(new Event(part[1], LocalDate.parse(part[2], Constants.format2)));
                TaskList.getTask(TaskList.sizeOf() - 1).isDone = false;
            }
        }
    }
}
