public class Consumer extends Thread{
    
    private Fifo fifo;
    private String message;
    private int number;
    
    public Consumer(Fifo f, String s, int n){
        fifo = f;
        message = s;
        number = n;
    }

    public void run(){
        go();
    }

    private void go(){
        while(true){
            try{
                var read = fifo.get();
                System.out.println("consumed " + message + " " + read + " " + System.currentTimeMillis());
                Thread.sleep(number);
            }catch(InterruptedException e){
                System.out.println("consumer interrupted");
            }
        }
    }
}
