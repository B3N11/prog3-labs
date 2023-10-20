import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import lambeer.*;

public class Main {

    public static ArrayList<Beer> beerList;
    private static HashMap<String, Command> commands;
    private static HashMap<String, Comparator<Beer>> comps;

    public static void main(String[] args) throws Exception{

        beerList = new ArrayList<>();
        createCommands();
        var bs = new BufferedReader(new InputStreamReader(System.in));

        while (true){

            System.out.print("# ");
            String[] line = bs.readLine().split(" ");

            try{
                var cmd = commands.get(line[0]);

                if(cmd == null)
                    throw new Exception("Nem létező parancs!");

                cmd.execute(line);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void checkParameter(Object[] list, int minLength) throws Exception{
        if(list == null || list.length < minLength)
            throw new Exception("Nem elegendő paraméter!");
    }

    private static void createCommands(){
        commands = new HashMap<String, Command>();

        var exit = new Exit();
        var list = new List();
        var add = new Add();
        var delete = new Delete();
        var find = new Find();
        var load = new Load();
        var save = new Save();
        var search = new Search();

        commands.put("exit", exit);
        commands.put("list", list);
        commands.put("add", add);
        commands.put("delete", delete);
        commands.put("find", find);
        commands.put("load", load);
        commands.put("save", save);
        commands.put("search", search);
    }
}
