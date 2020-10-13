package functions;

import tools.Constants;

import java.time.LocalDate;

public class Event extends Task {

    public Event(String Description, LocalDate at) {
        super(Description);
        this.date = at;
    }

    public String toString() { return "[E]" + super.toString() + " (at: " + date.format(Constants.format2) + ")"; }

    public String toSave() { return "[E]" + super.toSave() + "~&@#%" + date.format(Constants.format2); }
}
