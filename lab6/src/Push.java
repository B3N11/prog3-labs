public class Push implements Command{

    @Override
    public void execute(String[] cmd) {
        Main.stack.push(Integer.parseInt(cmd[1]));
    }    
}