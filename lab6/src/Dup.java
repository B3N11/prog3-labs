public class Dup implements Command{

    @Override
    public void execute(String[] cmd) {
        var number = Main.stack.peek();
        Main.stack.push(number);
    }    
}