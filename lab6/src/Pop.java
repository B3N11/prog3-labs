public class Pop implements Command{

    @Override
    public void execute(String[] cmd) {
        Main.stack.pop();
    }    
}