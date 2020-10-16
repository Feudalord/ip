package functions;

import java.time.LocalDate;

public class Task {
    protected String description;
    public boolean isDone;
    protected LocalDate date;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public LocalDate getDate() { return date; }

    public String getStatusIcon() {
        return (isDone ? "[y]" : "[n]"); //return tick or X symbols
    }

    public String toString() {
        return this.getStatusIcon() + " " + this.description;
    }

    public String toSave() { return this.getStatusIcon() + "~&@#%" + this.description; }

    public String getDescription() { return this.description; }

}