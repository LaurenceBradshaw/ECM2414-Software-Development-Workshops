public class FlagThreadApp {
    public static void main(String args[]) {
        FlagExample a = new FlagExample();
        FlagExample b = new FlagExample();

        a.start();
        b.start();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        
        a.stopThread();
        b.stopThread();
    }
}
