package tools;

import duke.DukeException;

import java.io.IOException;
import java.time.LocalDate;

public class Parser {
    private static final String no_desc = "No description entered ...";
    private static final String invalid = "Invalid Command !";
    private static final String no_cmd = "No command entered !";
    private static final String no_slash = "Require '/' to indicate time ...";
    private static final String wrong_num = "Invalid number entered ...";
    private static final String forbid_key = "Commands contains forbidden keyphrase ~&@#%";

    /**
     * Accepts raw input from the user. Decide if the input entered is valid. Warns user about
     * the different types of invalid inputs and execute valid inputs in the methods of the
     * Commands class.
     * @param input Raw input String entered by the user.
     * @return Returns a true to terminate the program in case "bye" command is given
     * and a false to keep looping the program.
     * @throws IOException save method produces IOException if the destination save file is not found.
     * @throws DukeException warns about the different types of invalid inputs the user may enter.
     */
    public static boolean parseInput(String input) throws IOException, DukeException {

        if (input.contains("~&@#%")) {
            throw new DukeException(forbid_key);
        } else if (input.equals("list")) {
            Commands.list();
        } else if (input.startsWith("list ")) {
            if (input.equals("list ")) {
                throw new DukeException(no_desc);
            }
            Commands.listDate(input.substring(5));
        } else if (input.equals("bye")) {
            return true;
        } else if (input.equals("help")) {
            Ui.helpMsg();
        } else if (input.startsWith("find ")) {
            if (input.equals("find ")) {
                throw new DukeException(no_desc);
            }
            Commands.find(input.substring(5));
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
            Commands.deadline(input.substring(9, index), LocalDate.parse(input.substring(index + 1), Constants.format1));
        } else if (input.startsWith("event ")) {
            if (input.equals("event ")) {
                throw new DukeException(no_desc);
            }
            int index = input.indexOf('/');
            if (index == -1) {
                throw new DukeException(no_slash);
            }
            Commands.event(input.substring(6, index), LocalDate.parse(input.substring(index + 1), Constants.format1));
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
        } else if (input.equals("todo") || input.equals("deadline") || input.equals("events") || input.equals("done") || input.equals("delete") || input.equals("find")) {
            throw new DukeException(no_desc);
        } else {
            throw new DukeException(invalid);
        }

        return false;
    }
}
