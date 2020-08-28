import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        String[] txt = new String[100];
        Scanner in = new Scanner(System.in);
        System.out.println("Hello Hello! I'm Duke\n" + "What can I do for you?");
        int i = 0;
        Task[] t = new Task[100];
        while (true) {
            txt[i] = in.nextLine();
            if(txt[i].equals("bye")){
                break;
            }else if (txt[i].equals("list")){
                System.out.println("Here are the tasks in your list:");
                for(int x = 0; x < i; x++){
                    System.out.printf("%d."+ t[x].getStatusIcon() + " %s\n", x+1, txt[x]);
                }
                txt[i] = in.nextLine();
                int num;
                if (txt[i].contains("done")){
                    num = Integer.parseInt(txt[i].substring(5));
                    t[num-1].isDone = true;
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.printf(t[num-1].getStatusIcon() + " %s\n", txt[num-1]);
                }
                continue;
            }
            System.out.printf("%s\n\n", txt[i]);
            t[i] = new Task(txt[i]);
            i++;
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
