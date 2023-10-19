import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final PC pc = new PC();

        // Create producer thread
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run(){
                try{
                    pc.produce();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        // Create consumer thread
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        producer.start();
        consumer.start();

        // Join both threads
        producer.join();
        consumer.join();
    }
    
    public static class PC {
        Random rng = new Random();
        final LinkedList<Integer> list = new LinkedList<>();
        final int capacity = 2;

        public void produce() throws InterruptedException {
            synchronized (list) {
                // If the list is already full, wait to be notified that 
                // the consumer has consumed a value from the list
                if (list.size() >= capacity) {
                    list.wait();
                }

                int randomInt = rng.nextInt(100);
                list.add(randomInt);
                System.out.println("Adding " + randomInt + " to the list...");
                list.notify();
            }
        }
        
        public void consume() throws InterruptedException {
            synchronized (list) {
                // If the list is empty, wait to be notified that
                // the producer has produced a value
                if (list.size() == 0) {
                    list.wait();
                }

                int consumedInt = list.removeLast();
                System.out.println("Consumed " + consumedInt + " from the list...");
                list.notify();
            }
        }
    }
}
