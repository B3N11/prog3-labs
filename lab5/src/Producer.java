public class Producer implements Runnable{

    private String message;
    private Fifo fifo;
    private int time;

    public Producer(String message, Fifo fifo, int time){
        this.message = message;
        this.fifo = fifo;
        this.time = time;
    }

    public void run(){
        go();
    }

    private void go(){

        int count = 0;
        while(true){
            try{
                fifo.put(message + " " + count);
                System.out.println("produced " + message + " " + (count++) + " " + System.currentTimeMillis());
                Thread.sleep(time);
            }catch(InterruptedException e){
                System.out.println("producer interrupted");
            }
        }    
    }   
}