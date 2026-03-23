import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;

public class SentinelStream {


    static void main() {
        ExecutorService threadPool = ThreadPool.getThreadPool();
        threadPool.execute(() -> IO.println("Thread 1"));
        threadPool.execute(() -> IO.println("Thread 2"));
        threadPool.execute(() -> IO.println("Thread 3\n\n"));
        Map<String,Integer> ratings =  Map.of("Not Good",1,"Good",2,"Better",3,"Nice",4,"Very great",5);

      try {
           Thread.sleep(2000);
          threadPool.execute(() -> ratings.entrySet().stream().filter((entryValue) -> entryValue.getValue() < 5).forEachOrdered(IO::println));
      }catch (InterruptedException e){
          e.getCause();
      }  finally {
          threadPool.shutdownNow();
      }

    }
}

