public class List implements Command{

    @Override
    public void execute(String[] cmd) {
        var list = Main.stack;

        for(var integer : list)
            System.out.print(integer + " ");
        System.out.println();
    }    
}