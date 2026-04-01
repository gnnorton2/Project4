import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class TaskSimulation implements Callable<Long> {
    final long totalPoints;

    public TaskSimulation(long totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public Long call() {
        long insideCircle = 0;
        for (long i = 0; i < totalPoints; i++) {
            double x = ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
            double y = ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
            if (x * x + y * y <= 1.0) {
                insideCircle++;
            }
        }
        return insideCircle;
    }
}
