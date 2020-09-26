package functions;

public class Task {
    protected String description;
    public boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "[y]" : "[n]"); //return tick or X symbols
    }

    public String toString() {
        return this.getStatusIcon() + " " + this.description;
    }

}