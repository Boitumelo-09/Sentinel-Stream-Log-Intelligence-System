import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public record ThreadPool() {
 private  static final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static ExecutorService getThreadPool() {
        return threadPool;
    }

}
