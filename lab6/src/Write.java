public class Write implements Command{

    @Override
    public void execute(String[] cmd) {
        var number = Main.stack.pop();
        System.out.println(number);
    }    
}