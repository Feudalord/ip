package duke;

import functions.*;

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
                    System.out.println("Here are the tasks in your list:");
                    for (int x = 0; x < i; x++) {
                        System.out.printf("%d.%s\n", x + 1, tasks[x]);
                    }
                } else if (txt.startsWith("done ")) {
                    if (txt.equals("done ")) {
                        throw new DukeException("No description entered ...");
                    }
                    int num;
                    num = Integer.parseInt(txt.substring(5));
                    if (num > i || num < 1) {
                        throw new DukeException("Invalid number entered ...");
                    }
                    tasks[num - 1].isDone = true;
                    DukeSave.save(tasks, i);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(tasks[num - 1]);
                } else if (txt.startsWith("todo ")) {
                    if (txt.equals("todo ")) {
                        throw new DukeException("No description entered ...");
                    }
                    tasks[i++] = new Todo(txt.substring(5));
                    DukeSave.save(tasks, i);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks[i - 1]);
                    System.out.printf("Now you have %d tasks in the list.\n", i);

                } else if (txt.startsWith("deadline ")) {
                    if (txt.equals("deadline ")) {
                        throw new DukeException("No description entered ...");
                    }
                    int index = txt.indexOf('/');
                    if (index != -1) {
                        tasks[i++] = new Deadline(txt.substring(9, index), txt.substring(index + 1));
                        DukeSave.save(tasks, i);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(tasks[i - 1]);
                        System.out.printf("Now you have %d tasks in the list.\n", i);
                    } else {
                        throw new DukeException("Require '/' to indicate time ...");
                    }
                } else if (txt.startsWith("event ")) {
                    if (txt.equals("event ")) {
                        throw new DukeException("No description entered ...");
                    }
                    int index = txt.indexOf('/');
                    if (index != -1) {
                        tasks[i++] = new Event(txt.substring(6, index), txt.substring(index + 1));
                        DukeSave.save(tasks, i);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(tasks[i - 1]);
                        System.out.printf("Now you have %d tasks in the list.\n", i);
                    } else {
                        throw new DukeException("Require '/' to indicate time ...");
                    }
                } else if (txt.equals("bye")) {
                    break;
                } else if (txt.equals("todo") || txt.equals("deadline") || txt.equals("events") || txt.equals("done")) {
                    throw new DukeException("No description entered ...");
                } else {
                    throw new DukeException("Invalid Command! Try 'todo','deadline','event','list','done','bye'!");
                }
            } catch (Exception m) {
                System.out.println("An exception has occurred: " + m);
            }

        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
