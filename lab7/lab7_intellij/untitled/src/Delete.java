import lambeer.Beer;

import java.util.Collections;

public class Delete implements Command{
    @Override
    public void execute(String[] cmd) throws Exception {
        Main.checkParameter(cmd, 2);

        var beer = Collections.binarySearch(Main.beerList, new Beer(cmd[1], "", 0), (b1, b2) -> b1.getName().compareTo(b2.getName()));

        if(beer < 0)
            throw new Exception("Nincs ilyen sör.");

        Main.beerList.remove(beer);
    }
}
