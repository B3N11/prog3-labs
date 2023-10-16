public class Add implements Command{

    @Override
    public void execute(String[] cmd) {
        var num1 = Main.stack.pop();
        var num2 = Main.stack.pop();

        Main.stack.push(num1 + num2);
    }    
}