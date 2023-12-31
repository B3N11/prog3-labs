import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Save implements Command{
    @Override
    public void execute(String[] cmd) throws Exception {
        Main.checkParameter(cmd, 2);

        var fs = new FileOutputStream(cmd[1]);
        var out = new ObjectOutputStream(fs);

        out.writeObject(Main.beerList);
        out.close();
    }
}
