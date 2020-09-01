public class Deadline extends Task{
    protected String by;
    public Deadline(String Description, String by){
        super(Description);
        this.by = by;
    }
    public String toString(){
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
