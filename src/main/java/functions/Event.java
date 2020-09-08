package functions;

public class Event extends Task {
    protected String at;

    public Event(String Description, String at) {
        super(Description);
        this.at = at;
    }

    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
