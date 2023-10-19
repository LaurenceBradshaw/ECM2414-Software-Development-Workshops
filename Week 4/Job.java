public class Job implements Runnable{
    public int jobNumber;

    Job(int jobNumber){
        this.jobNumber = jobNumber;
    }

    @Override
    public void run(){
        System.out.println("Job: " + jobNumber + " is being processed by thread: " + Thread.currentThread().getName());

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Job: " + jobNumber + " is ending in thread " + Thread.currentThread().getName());
    }
}
