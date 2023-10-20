public class Search implements Command{
    @Override
    public void execute(String[] cmd) throws Exception {
        Main.checkParameter(cmd, 2);

        for(var beer : Main.beerList)
            if(beer.getName().equals(cmd[1]))
                System.out.println(beer.toString());
    }
}
