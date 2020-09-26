package duke;

import functions.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.*;

public class DukeSave {
    static void save(ArrayList<Task> t, int i) throws IOException {
        StringBuilder str = new StringBuilder();
        for (int x = 0; x < i; x++) {
            str.append(t.get(x).toString() + System.lineSeparator());
        }
        FileWriter fw = new FileWriter("./data/save.txt");
        fw.write(String.valueOf(str));
        fw.close();
    }

    static int load(ArrayList<Task> t) throws IOException {
        if(!Files.exists(Paths.get("./data"))){
            Files.createDirectory(Paths.get("./data"));
        }
        if(!Files.exists(Paths.get("./data/save.txt"))){
            Files.createFile(Paths.get("./data/save.txt"));
        }
        int i = 0;
        File f = new File("./data/save.txt");
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String str = s.nextLine();
            String part[] = str.split(" ");
            if (part[0].equals("[T][y]")) {
                t.add(i, new Todo(part[1]));
                t.get(i++).isDone = true;
            } else if (part[0].equals("[T][n]")) {
                t.add(i, new Todo(part[1]));
                t.get(i++).isDone = false;
            } else if (part[0].equals("[D][y]")) {
                t.add(i, new Deadline(part[1], part[3].substring(0, part[3].length() - 1)));
                t.get(i++).isDone = true;
            } else if (part[0].equals("[D][n]")) {
                t.add(i, new Deadline(part[1], part[3].substring(0, part[3].length() - 1)));
                t.get(i++).isDone = false;
            } else if (part[0].equals("[E][y]")) {
                t.add(i, new Event(part[1], part[3].substring(0, part[3].length() - 1)));
                t.get(i++).isDone = true;
            } else if (part[0].equals("[E][n]")) {
                t.add(i, new Event(part[1], part[3].substring(0, part[3].length() - 1)));
                t.get(i++).isDone = false;
            }
        }
        return i;
    }
}
