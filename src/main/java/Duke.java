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
        while (true) {
            txt[i] = in.nextLine();
            if(txt[i].equals("bye")){
                break;
            }else if (txt[i].equals("list")){
                for(int x = 0; x < i; x++){
                    System.out.printf("%d. %s\n", x+1, txt[x]);
                }
                continue;
            }
            System.out.printf("%s\n\n", txt[i]);
            i++;
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
