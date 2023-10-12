public class MyCounterApp {
    public static void main(String[] args) {
        final MyCounter a = new MyCounter();

        System.out.println("Current Thread is " + Thread.currentThread().getName());

        Thread t1 = new Thread(new Runnable() {
            public void run(){
                for (int i = 1; i <= 1000; i++) {
                    a.addTwo();
                }
                System.out.println("Value on thread 1 on exit:" + a.countValue());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run(){
                for (int i = 1; i <= 1000; i++) {
                    a.subtractTwo();
                }
                System.out.println("Value on thread 2 on exit:" + a.countValue());
            }
        });

        t1.start();
        t2.start();
    }
}
