import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadPoolApp {
    public static void main(String[] args) {
        int numberOfJobs = 9;
        int numberOfThreads = 4;

        ExecutorService pool = Executors.newFixedThreadPool(numberOfThreads);

        Job[] jobs = new Job[numberOfJobs];
        for(int i = 0; i < numberOfJobs; i++){
            jobs[i] = new Job(i);
            pool.execute(jobs[i]);
        }
        pool.shutdown(); // All submitted tasks are executed and no new tasks will be accepted

        System.out.println("Last line " + Thread.currentThread().getName());
    }
}
