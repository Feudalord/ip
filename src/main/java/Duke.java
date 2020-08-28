import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        String txt;
        Scanner in = new Scanner(System.in);
        System.out.println("Hello Hello! I'm Duke\n" + "What can I do for you?");
        while (true) {
            txt = in.nextLine();
            if(txt.equals("bye")){
                break;
            }
            System.out.printf("%s\n\n", txt);
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
