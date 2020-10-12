package tools;

import duke.DukeException;

import java.io.IOException;

public class Parser {
    private static final String no_desc = "No description entered ...";
    private static final String invalid = "Invalid Command !";
    private static final String no_cmd = "No command entered !";
    private static final String no_slash = "Require '/' to indicate time ...";
    private static final String wrong_num = "Invalid number entered ...";

    public static boolean parseInput(String input) throws IOException, DukeException {

        if (input.equals("list")) {
            Commands.list();
        } else if (input.equals("bye")) {
            return true;
        } else if (input.equals("help")) {
            Ui.helpMsg();
        } else if (input.startsWith("done ")) {
            if (input.equals("done ")) {
                throw new DukeException(no_desc);
            }
            int num = Integer.parseInt(input.substring(5));
            if (num > TaskList.sizeOf() || num < 1) {
                throw new DukeException(wrong_num);
            }
            Commands.done(num);
        } else if (input.startsWith("todo ")) {
            if (input.equals("todo ")) {
                throw new DukeException(no_desc);
            }
            Commands.todo(input.substring(5));
        } else if (input.startsWith("deadline ")) {
            if (input.equals("deadline ")) {
                throw new DukeException(no_desc);
            }
            int index = input.indexOf('/');
            if (index == -1) {
                throw new DukeException(no_slash);
            }
            Commands.deadline(input.substring(9, index), input.substring(index + 1));
        } else if (input.startsWith("event ")) {
            if (input.equals("event ")) {
                throw new DukeException(no_desc);
            }
            int index = input.indexOf('/');
            if (index == -1) {
                throw new DukeException(no_slash);
            }
            Commands.event(input.substring(6, index), input.substring(index + 1));
        } else if (input.startsWith("delete ")) {
            if (input.equals("delete ")) {
                throw new DukeException(no_desc);
            }
            int num = Integer.parseInt(input.substring(7));
            if (num > TaskList.sizeOf() || num < 1) {
                throw new DukeException(wrong_num);
            }
            Commands.delete(num);
        } else if (input.equals("")) {
            throw new DukeException(no_cmd);
        } else if (input.equals("todo") || input.equals("deadline") || input.equals("events") || input.equals("done") || input.equals("delete")) {
            throw new DukeException(no_desc);
        } else {
            throw new DukeException(invalid);
        }

        return false;
    }
}
