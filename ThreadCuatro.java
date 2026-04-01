import java.util.concurrent.ThreadLocalRandom;

public class ThreadCuatro implements Runnable {
    final private long totalPoints;
    private long insideCircle;

    public ThreadCuatro(long totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void run(){
        for(long i=0; i<totalPoints; i++){
            // We generate a random point with coordinates (x, y)
            // inside this square, which is centered at the origin
            // and goes from -1.0 to 1.0 in both the x and y directions.
            double x = ThreadLocalRandom.current().nextDouble(-1.0,1.0);
            double y = ThreadLocalRandom.current().nextDouble(-1.0,1.0);
            // Check if the point (x, y) is inside the unit circle centered
            // at (0, 0). A point is inside the circle if its distance from
            // the origin is less than or equal to 1, i.e., x*x + y*y <= 1
            if(x*x+y*y <= 1.0){
                insideCircle ++;
            }
        }
    }
    public long getInsideCircle() {
        return insideCircle;
    }
}
