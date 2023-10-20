import lambeer.Beer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Load implements Command{
    @Override
    public void execute(String[] cmd) throws Exception {
        Main.checkParameter(cmd, 2);

        try{
            var fs = new FileInputStream(cmd[1]);
            var in = new ObjectInputStream(fs);
            Main.beerList = (ArrayList<Beer>) in.readObject();
        }catch (IOException e){
            throw new Exception("A fájl beolvasás sikertelen!");
        }catch (ClassNotFoundException e){
            throw new Exception("A fájl formátuma helytelen!");
        }
    }
}
