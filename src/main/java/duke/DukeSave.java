package duke;
import functions.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.*;

public class DukeSave {
    static void save(Task[] t, int i) throws IOException{
        StringBuilder str = new StringBuilder();
        for (int x = 0; x<i; x++){
            str.append(t[x].toString() + System.lineSeparator());
        }
        FileWriter fw = new FileWriter("src\\main\\java\\duke\\save.txt");
        fw.write(String.valueOf(str));
        fw.close();
    }
    static int load(Task[] t) throws FileNotFoundException{
        int i = 0;
        File f = new File("src\\main\\java\\duke\\save.txt");
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String str = s.nextLine();
            String part[] = str.split(" ");
            if (part[0].equals("[T][\u2713]")) {
                t[i] = new Todo(part[1]);
                t[i++].isDone = true;
            } else if (part[0].equals("[T][\u2718]")) {
                t[i] = new Todo(part[1]);
                t[i++].isDone = false;
            } else if (part[0].equals("[D][\u2713]")) {
                t[i] = new Deadline(part[1], part[3].substring(0, part[3].length()-1));
                t[i++].isDone = true;
            } else if (part[0].equals("[D][\u2718]")) {
                t[i] = new Deadline(part[1], part[3].substring(0, part[3].length()-1));
                t[i++].isDone = false;
            } else if (part[0].equals("[E][\u2713]")) {
                t[i] = new Event(part[1], part[3].substring(0, part[3].length()-1));
                t[i++].isDone = true;
            } else if (part[0].equals("[E][\u2718]")) {
                t[i] = new Event(part[1], part[3].substring(0, part[3].length()-1));
                t[i++].isDone = false;
            }
        }
        return i;
    }
}
