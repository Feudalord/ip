package duke;

import functions.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello Hello! I'm Duke\n" + "What can I do for you?");
        int i = 0;
        String txt;
        Scanner in = new Scanner(System.in);
<<<<<<< HEAD
        //Task[] tasks = new Task[100];
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            txt = in.nextLine();
            try {
                if (txt.equals("list")) {                        //CMD LIST
=======
        Task[] tasks = new Task[100];
        try {
            i = DukeSave.load(tasks);
        }catch (Exception m) {
            System.out.println("An exception has occurred: " + m);
        }
        while (true) {
            txt = in.nextLine();
            try {

                if (txt.equals("")) {
                    throw new DukeException("No command entered !");
                } else if (txt.equals("list")) {
>>>>>>> branch-Level-7
                    System.out.println("Here are the tasks in your list:");
                    for (int x = 0; x < i; x++) {
                        System.out.printf("%d.%s\n", x + 1, tasks.get(x));
                    }
                } else if (txt.startsWith("done ")) {            //CMD DONE
                    if (txt.equals("done ")) {
                        throw new DukeException("No description entered ...");
                    }
                    int num;
                    num = Integer.parseInt(txt.substring(5));
                    if (num > i || num < 1) {
                        throw new DukeException("Invalid number entered ...");
                    }
<<<<<<< HEAD
                    tasks.get(num - 1).isDone = true;
=======
                    tasks[num - 1].isDone = true;
                    DukeSave.save(tasks, i);
>>>>>>> branch-Level-7
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(tasks.get(num - 1));
                } else if (txt.startsWith("todo ")) {            //CMD TODO
                    if (txt.equals("todo ")) {
                        throw new DukeException("No description entered ...");
                    }
<<<<<<< HEAD
                    tasks.add(i++, new Todo(txt.substring(5)));
=======
                    tasks[i++] = new Todo(txt.substring(5));
                    DukeSave.save(tasks, i);
>>>>>>> branch-Level-7
                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks.get(i - 1));
                    System.out.printf("Now you have %d tasks in the list.\n", i);

                } else if (txt.startsWith("deadline ")) {        //CMD DEADLINE
                    if (txt.equals("deadline ")) {
                        throw new DukeException("No description entered ...");
                    }
                    int index = txt.indexOf('/');
                    if (index != -1) {
<<<<<<< HEAD
                        tasks.add(i++, new Deadline(txt.substring(9, index), txt.substring(index + 1)));
=======
                        tasks[i++] = new Deadline(txt.substring(9, index), txt.substring(index + 1));
                        DukeSave.save(tasks, i);
>>>>>>> branch-Level-7
                        System.out.println("Got it. I've added this task:");
                        System.out.println(tasks.get(i - 1));
                        System.out.printf("Now you have %d tasks in the list.\n", i);
                    } else {
                        throw new DukeException("Require '/' to indicate time ...");
                    }
                } else if (txt.startsWith("event ")) {          //CMD EVENT
                    if (txt.equals("event ")) {
                        throw new DukeException("No description entered ...");
                    }
                    int index = txt.indexOf('/');
                    if (index != -1) {
<<<<<<< HEAD
                        tasks.add(i++, new Event(txt.substring(6, index), txt.substring(index + 1)));
=======
                        tasks[i++] = new Event(txt.substring(6, index), txt.substring(index + 1));
                        DukeSave.save(tasks, i);
>>>>>>> branch-Level-7
                        System.out.println("Got it. I've added this task:");
                        System.out.println(tasks.get(i - 1));
                        System.out.printf("Now you have %d tasks in the list.\n", i);
                    } else {
                        throw new DukeException("Require '/' to indicate time ...");
                    }
                } else if (txt.startsWith("delete ")) {             //CMD DELETE
                    if (txt.equals("delete ")) {
                        throw new DukeException("No description entered ...");
                    }
                    int num;
                    num = Integer.parseInt(txt.substring(7));
                    if (num > i || num < 1) {
                        throw new DukeException("Invalid number entered ...");
                    }
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(tasks.get(i - 1));
                    System.out.printf("Now you have %d tasks in the list.\n", i - 1);
                    tasks.remove(num - 1);
                    i--;
                } else if (txt.equals("bye")) {                 //CMD BYE
                    break;
                } else if (txt.equals("")) {                    //Exceptions handling
                    throw new DukeException("No command entered !");
                } else if (txt.equals("todo") || txt.equals("deadline") || txt.equals("events") || txt.equals("done") || txt.equals("delete")) {
                    throw new DukeException("No description entered ...");
                } else {
                    throw new DukeException("Invalid Command! Try 'todo','deadline','event','list','delete','done','bye'!");
                }
            } catch (Exception m) {
                System.out.println("An exception has occurred: " + m);
            }

        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
