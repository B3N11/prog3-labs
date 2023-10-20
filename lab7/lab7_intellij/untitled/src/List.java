import lambeer.Beer;

import java.util.Collections;
import java.util.Comparator;

public class List implements Command{

    @Override
    public void execute(String[] cmd) throws  Exception{
        if(Main.beerList.isEmpty())
            throw new Exception("Nincs még sör a listában!");

        Comparator<Beer> cmp = Main.comps.get("name");

        if(cmd.length >= 2){

            cmp = Main.comps.get(cmd[1]);

            if(cmp == null)
                throw new Exception("Helytelen argumentum!");

            Collections.sort(Main.beerList, cmp);
        }

        for(var beer : Main.beerList)
            System.out.println(beer.toString());
    }    
}