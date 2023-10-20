import lambeer.Beer;

public class Add implements Command{

    @Override
    public void execute(String[] cmd) throws Exception{
        Main.checkParameter(cmd, 4);

        double strength = 0;
        try{
            strength = Double.parseDouble(cmd[3]);
        }catch (Exception e){
            throw new Exception("Nem megfelelő formátum!");
        }

        var newBeer = new Beer(cmd[1], cmd[2], strength);
        Main.beerList.add(newBeer);
    }    
}