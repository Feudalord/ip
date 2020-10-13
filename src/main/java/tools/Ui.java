package tools;

public class Ui {
    public static void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("\n\nHello from\n" + logo);
        System.out.println("Hello Hello! I'm Duke!");
        System.out.println("I am your Task Management Assistant.");
        System.out.println("What can I do for you?");
        System.out.println("\nPlease enter <help> for a list of available commands");
    }

    public static void addTaskMsg() {
        System.out.println("Got it. I've added this task:");
        System.out.println(TaskList.getTask(TaskList.sizeOf() - 1));
        System.out.printf("Now you have %d tasks in the list.\n", TaskList.sizeOf());
    }

    public static void doneTaskMsg(int num) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(TaskList.getTask(num - 1));
    }

    public static void listTaskMsg() {
        System.out.println("Here are the tasks in your list:");
    }

    public static void deleteTaskMsg(int num) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(TaskList.getTask(num - 1));
        System.out.printf("Now you have %d tasks in the list.\n", TaskList.sizeOf() - 1);
    }

    public static void helpMsg() {
        System.out.println("List of Available Commands:\n");
        System.out.println("<list> Show all available tasks");
        System.out.println("<list YYYY-MM-DD> Show all available tasks on the given day");
        System.out.println("<bye> Exit program");
        System.out.println("<todo -desc> Add Task");
        System.out.println("<deadline -desc/YYYY-MM-DD> Add deadline by /when");
        System.out.println("<event -desc/YYYY-MM-DD> Add event at /when");
        System.out.println("<done -num> Mark Task as Done");
        System.out.println("<delete -num> Delete Task");
    }

    public static void byeMsg(){
        System.out.println("Bye. Hope to see you again soon!");
    }
}
