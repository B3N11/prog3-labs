import lambeer.Beer;

import java.util.Collections;
import java.util.Comparator;

public class List implements Command{

    @Override
    public void execute(String[] cmd) throws  Exception{
        if(Main.beerList.isEmpty())
            throw new Exception("Nincs még sör a listában!");

        if(cmd.length >= 2){

            if(cmd[1].equals("name"))
                Collections.sort(Main.beerList, (b1, b2) -> b1.getName().compareTo(b2.getName()));
            else if(cmd[1].equals("style"))
                Collections.sort(Main.beerList, (b1, b2) -> b1.getStyle().compareTo(b2.getStyle()));
            else if(cmd[1].equals("strength"))
                Collections.sort(Main.beerList, Comparator.comparing((Beer b1) -> b1.getStrength()));
            else
                throw new Exception("Helytelen argumentum!");
        }

        for(var beer : Main.beerList)
            System.out.println(beer.toString());
    }    
}