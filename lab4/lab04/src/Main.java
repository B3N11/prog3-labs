import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    private ArrayList<Beer> beerList;

    private Main(){
        beerList = new ArrayList<>();
    }

    public static void main(String[] args) throws Exception{

        Main program = new Main();
        var bs = new BufferedReader(new InputStreamReader(System.in));

        while (true){

            System.out.print("# ");
            String[] line = bs.readLine().split(" ");

            if(line[0].equals("exit"))
                break;

            try{
                if(line[0].equals("add"))
                    program.add(line);

                if(line[0].equals("list"))
                    program.list(line);

                if(line[0].equals("save"))
                    program.save(line);

                if(line[0].equals("load"))
                    program.load(line);

                if(line[0].equals("search"))
                    program.search(line);

                if(line[0].equals("find"))
                    program.find(line);

                if(line[0].equals("delete"))
                    program.delete(line);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkParameter(Object[] list, int minLength) throws Exception{
        if(list == null || list.length < minLength)
            throw new Exception("Nem elegendő paraméter!");
    }

    private void add(String[] line) throws Exception{
        checkParameter(line, 4);

        double strength = 0;
        try{
            strength = Double.parseDouble(line[3]);
        }catch (Exception e){
            throw new Exception("Nem megfelelő formátum!");
        }

        var newBeer = new Beer(line[1], line[2], strength);
        beerList.add(newBeer);
    }

    private void delete(String[] line) throws Exception{
        checkParameter(line, 2);

        var cmp = new NameComparator();
        Collections.sort(beerList, cmp);

        var beer = Collections.binarySearch(beerList, new Beer(line[1], "", 0), cmp);

        if(beer < 0)
            throw new Exception("Nincs ilyen sör.");

        beerList.remove(beer);
    }

    private void list(String[] line) throws Exception{
        if(beerList.isEmpty())
            throw new Exception("Nincs még sör a listában!");

        if(line.length >= 2){
            Comparator cmp = line[1].equals("name") ? new NameComparator() : line[1].equals("style") ? new StyleComparator() : line[1].equals("strength") ? new StrengthComparator() : null;

            if(cmp == null)
                throw new Exception("Helytelen argumentum!");

            Collections.sort(beerList, cmp);
        }

        for(var beer : beerList)
            System.out.println(beer.toString());
        return;
    }

    private void save(String[] line) throws Exception{
        checkParameter(line, 2);

        var fs = new FileOutputStream(line[1]);
        var out = new ObjectOutputStream(fs);

        out.writeObject(beerList);
        out.close();
    }

    private void load(String[] line) throws Exception{
        checkParameter(line, 2);

        try{
            var fs = new FileInputStream(line[1]);
            var in = new ObjectInputStream(fs);
            beerList = (ArrayList<Beer>) in.readObject();
        }catch (IOException e){
            throw new Exception("A fájl beolvasás sikertelen!");
        }catch (ClassNotFoundException e){
            throw new Exception("A fájl formátuma helytelen!");
        }
    }

    private void search(String[] line) throws  Exception{
        checkParameter(line, 2);

        for(var beer : beerList)
            if(beer.getName().equals(line[1]))
                System.out.println(beer.toString());
    }

    private void find(String[] line) throws  Exception{
        checkParameter(line, 2);

        for(var beer : beerList)
            if(beer.getName().contains(line[1]))
                System.out.println(beer.toString());
    }
}
