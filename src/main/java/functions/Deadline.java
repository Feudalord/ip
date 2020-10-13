package functions;

import tools.Constants;

import java.time.LocalDate;

public class Deadline extends Task {

    public Deadline(String Description, LocalDate by) {
        super(Description);
        this.date = by;
    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + date.format(Constants.format2) + ")";
    }

    public String toSave() { return "[D]" + super.toSave() + "~&@#%" + date.format(Constants.format2); }
}
