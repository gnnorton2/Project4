import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        Instant start = Instant.now(); // record start time
        ExecutorService es = Executors.newFixedThreadPool(4); // 4 threads
        long totalPoints = 10_000_000_000L; // total random points
        long pointsPerThread = totalPoints / 4; // thread handles 1/4
        // 4 simulation tasks to executor
        Future<Long>[] future = new Future[4];
        for (int i = 0; i < 4; i++) {
            future[i] = es.submit(new TaskSimulation(pointsPerThread));
        }
        // collect results
        long insideCircle = 0;
        for (Future<Long> f : future) {
            insideCircle += f.get();
        }
        double estimate = (double) insideCircle / totalPoints * 4.0; // pi in main thread
        Instant finish = Instant.now(); // end time
        long runtime = Duration.between(start, finish).toMillis();
        // output
        System.out.println("\nEstimated pi: " + estimate);
        System.out.println("\nTotal runtime: %.3f seconds" + (runtime / 1000.0));
        es.shutdown();
        // do not have the while(true) loop here
        // submit four threads es.submit(new ThreadUno("Thread-1", totalPoints/4));
    }
}
