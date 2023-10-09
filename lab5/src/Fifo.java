import java.util.LinkedList;

public class Fifo {
    
    LinkedList<String> strings;

    public Fifo(){
        strings = new LinkedList<String>();
    }

    public synchronized void put(String newString) throws InterruptedException{
        if(newString == null)
            return;
        
        while(strings.size() >= 10)
            wait();
            
        System.out.println("FIFO.put() THREAD: " + Thread.currentThread().getId());
        strings.add(newString);
        
        notifyAll();
    }

    public synchronized String get() throws InterruptedException{
        while(strings.isEmpty())
            wait();
        
        System.out.println("FIFO.get() THREAD: " + Thread.currentThread().getId());
        var last = strings.get(0);
        strings.remove(0);

        notifyAll();

        return last;
    }
}
