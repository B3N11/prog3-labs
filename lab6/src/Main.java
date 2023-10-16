import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class Main{

    public static ArrayDeque<Integer> stack;
    public static Scanner scanner;

    public static void main(String[] args){
        stack = new ArrayDeque<Integer>();
        scanner = new Scanner(System.in);

        HashMap<String, Command> map = new HashMap<String, Command>();
        createCommands(map);

        while(true){
            System.out.print("# ");
            var line = scanner.nextLine();
            var cmd = line.split(" ");

            var command = map.get(cmd[0]);
            command.execute(cmd);
        }
    }

    private static void createCommands(HashMap<String, Command> map){
        var dup = new Dup();
        var exit = new Exit();
        var list = new List();
        var pop = new Pop();
        var push = new Push();
        var read = new Read();
        var write = new Write();
        var add = new Add();
        var sub = new Sub();
        var mult = new Mult();
        var div = new Div();

        map.put("dup", dup);
        map.put("exit", exit);
        map.put("list", list);
        map.put("pop", pop);
        map.put("push", push);
        map.put("read", read);
        map.put("write", write);
        map.put("add", add);
        map.put("sub", sub);
        map.put("mult", mult);
        map.put("div", div);
    }
}