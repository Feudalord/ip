package functions;


public class Todo extends Task {
    public Todo(String Description) {
        super(Description);
    }

    public String toString() {
        return "[T]" + super.toString();
    }

    public String toSave() { return "[T]" + super.toSave(); }
}
