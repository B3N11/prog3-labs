public class Read implements Command{

    @Override
    public void execute(String[] cmd) {
        var number = Integer.parseInt(Main.scanner.nextLine());
        Main.stack.push(number);
    }    
}