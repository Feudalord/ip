package duke;

import tools.Parser;
import tools.Storage;
import tools.Ui;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Ui.showWelcome();
        Scanner in = new Scanner(System.in);
        try {
            Storage.setFilepath("./data/save.txt", "./data");
            Storage.load();
        } catch (Exception e) {
            System.out.println(e);
        }
        while (true) {
            try {
                boolean end = Parser.parseInput(in.nextLine());
                if (end) {
                    Ui.byeMsg();
                    return;
                }
            } catch (DateTimeParseException e) {
                Ui.parseExceptionMsg();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}