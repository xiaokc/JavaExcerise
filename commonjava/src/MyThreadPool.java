
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 动手写一个简单的线程池
 * Created by xkc on 9/9/16.
 */
public class MyThreadPool {
    private final int WORKSIZE;
    private List<Work> works= Collections.synchronizedList(new ArrayList<Work>());
    private LinkedList<Runnable> jobs=new LinkedList<>();
    public static void main(String args[])
    {
        final MyThreadPool pool=new MyThreadPool(4);
        //test
        final AtomicLong count1=new AtomicLong();
        long begin=System.currentTimeMillis();
        for(int i=0;i<1000;i++)
        {
            pool.execute(new Runnable() {

                @Override
                public void run() {
                    count1.getAndIncrement();
                }
            });
        }
        System.out.println((System.currentTimeMillis()-begin));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(count1.get());
    }
    public MyThreadPool(int size)
    {
        WORKSIZE=size;
        initWorkThread();
    }
    public void initWorkThread()
    {
        for(int i=0;i<WORKSIZE;i++)
        {
            Work work=new Work();
            works.add(work);
            new Thread(work,"workThread-"+i).start();
        }
    }
    public void execute(Runnable job)
    {
        synchronized(jobs)
        {
            jobs.add(job);
            jobs.notify();
        }
    }
    class Work implements Runnable{

        private volatile boolean isRun=true;
        @Override
        public void run() {
            while(isRun)
            {
                Runnable job=null;
                synchronized(jobs)
                {
                    while(jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            return;
                        }
                    }
                    job=jobs.removeFirst();
                }
                if(job!=null)
                {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    job.run();
                }
            }
        }
        public void shutdown(){
            isRun=false;
        }
    }
}
