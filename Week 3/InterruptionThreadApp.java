public class InterruptionThreadApp {
    public static void main(String[] args) {
        Thread a = new Thread(new InterruptionExample());
        Thread b = new Thread(new InterruptionExample());

        a.start();
        b.start();
        
        System.out.println("Main Thread is still running");

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        
        a.interrupt();
        b.interrupt();
    }
}
