import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(4);

        long totalPoints = 10_000_000_000L;
        long insideCircle = 0;

        ThreadUno threadUno = new ThreadUno(totalPoints / 4);
        ThreadDos threadDos = new ThreadDos(totalPoints / 4);
        ThreadTres threadTres = new ThreadTres(totalPoints / 4);
        ThreadCuatro threadcuatro = new ThreadCuatro(totalPoints / 4);
        //do not have the while(true) loop here
        // submit four threads es.submit(new ThreadUno("Thread-1", totalPoints/4));
    }
}
