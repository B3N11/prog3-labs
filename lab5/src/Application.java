public class Application {
    public static void main(String[] args) throws Exception {
        var fifo = new Fifo();
        var producer = new Producer("imTheProducer1", fifo, 1000);
        var producer2 = new Producer("imTheProducer2", fifo, 1000);
        var producer3 = new Producer("imTheProducer3", fifo, 1000);

        var consumer = new Consumer(fifo, "imTheConsumer1", 100);
        var consumer2 = new Consumer(fifo, "imTheConsumer2", 100);
        var consumer3 = new Consumer(fifo, "imTheConsumer3", 100);
        
        Thread thread = new Thread(producer);
        Thread thread2 = new Thread(producer2);
        Thread thread3 = new Thread(producer3);

        thread.start();
        thread2.start();
        thread3.start();

        consumer.start();
        consumer2.start();
        consumer3.start();
    }
}
