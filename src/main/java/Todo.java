public class Todo extends Task{
    public Todo(String Description){
        super(Description);
    }
    public String toString(){
        return "[T]" + super.toString();
    }
}
