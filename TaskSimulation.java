import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class TaskSimulation implements Callable<Long> {
    final long totalPoints; // total # of random points
    // constructor to initialize totalPoints for task

    public TaskSimulation(long totalPoints) {
        this.totalPoints = totalPoints;
    }

    // performs monte carlo simulation
    @Override
    // when the task is submitted to executorService
    public Long call() {
        long insideCircle = 0;
        for (long i = 0; i < totalPoints; i++) { // check whether they fall inside or out of circle
            double x = ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
            double y = ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
            // check if point lies inside circle
            if (x * x + y * y <= 1.0) {
                insideCircle++;
            }
        }
        return insideCircle;
    }
}