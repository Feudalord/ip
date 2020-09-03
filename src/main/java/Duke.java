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

        while (true) {
            txt = in.nextLine();
            if (txt.equals("list")){
                System.out.println("Here are the tasks in your list:");
                for(int x = 0; x < i; x++){
                    System.out.printf("%d.%s\n", x+1, tasks[x]);
                }
            }else if (txt.startsWith("done ")){
                int num;
                num = Integer.parseInt(txt.substring(5));
                tasks[num - 1].isDone = true;
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(tasks[num - 1]);
            }else if (txt.startsWith("todo ")){
                tasks[i++] = new Todo(txt.substring(5));
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[i-1]);
                System.out.printf("Now you have %d tasks in the list.\n", i);

            }else if (txt.startsWith("deadline ")){
                int index = txt.indexOf('/');
                if (index != -1) {
                    tasks[i++] = new Deadline(txt.substring(9,index), txt.substring(index+1));
                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks[i-1]);
                    System.out.printf("Now you have %d tasks in the list.\n", i);
                }else{
                    System.out.println("Missing '/' in the command");
                }
            }else if (txt.startsWith("event ")){
                int index = txt.indexOf('/');
                if (index != -1) {
                    tasks[i++] = new Event(txt.substring(6,index), txt.substring(index+1));
                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks[i-1]);
                    System.out.printf("Now you have %d tasks in the list.\n", i);
                }else{
                    System.out.println("Missing '/' in the command");
                }
            }else if(txt.equals("bye")){
                break;
            }else{
                System.out.printf("%s\n\n", txt);
                tasks[i++] = new Task(txt);
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
