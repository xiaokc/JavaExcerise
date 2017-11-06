import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 通过3种方式创建Map对象，使用ExecutorService并发执行5个线程
 * 对比ConcurrentHashMap, Collections.synchronizedMap, Hashtable
 * 这三种线程安全的HashMap的执行效率
 * Created by xkc on 8/30/16.
 */
public class ConcurrentHashMapVsSynchronizedMap {
    private static final int THREAD_POOL_SIZE = 5;
    private static Map<String,Integer> concurrentHashMapObject = null;
    private static Map<String,Integer> synchronizedMapObject = null;
    private static Map<String,Integer> hashtableObject = null;

    public static void main(String[] args) throws InterruptedException{
        //测试Hashtable
        hashtableObject = new Hashtable<>();
        performTest(hashtableObject);

        //测试ConcurrentHashMap
        concurrentHashMapObject = new ConcurrentHashMap<>();
        performTest(concurrentHashMapObject);

        //测试synchronizedMap
        synchronizedMapObject = Collections.synchronizedMap(new HashMap<>());
        performTest(synchronizedMapObject);


    }



    private static void performTest(Map<String, Integer> threads) throws InterruptedException {
        System.out.println("Test started from:"+threads.getClass());

        long averageTime = 0;
        for (int i = 0; i < 5; i ++){
            long startTime = System.nanoTime();
            ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            for (int j = 0; j < THREAD_POOL_SIZE; j ++){
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10000;i ++){
                            Integer randomNum = (int)Math.ceil(Math.random() * 15000);
                            threads.get(String.valueOf(randomNum));
                            threads.put(String.valueOf(randomNum),randomNum);
                        }
                    }
                });
            }

            // Make sure executor stops
            executorService.shutdown();
            // Blocks until all tasks have completed execution after a shutdown request
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

            long endTime = System.nanoTime();
            long totalTime = (endTime - startTime) / 1000000L;
            averageTime += totalTime;

            System.out.println("50k entried added/retrieved in " + totalTime+"ms");

        }

        System.out.println("For "+threads.getClass() + " the average time is "+ averageTime/5);

    }
}
