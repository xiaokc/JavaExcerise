package mythreadpool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 线程池服务类
 * 这是线程池最核心的一个类。它在被创建了时候就创建了几 个线程对象,
 * 但是这些线程并没有启动运行,但调用了start()方法启动线程池服务时,它们才真正运 行。
 * stop()方法可以停止线程池服务,同时停止池中所有线程的运行。
 * 而runTask(Task task)方法是将 一个新的待执行任务交与线程池来运行。
 * Created by xkc on 9/19/16.
 */
public class ThreadPoolService {
    //线程数
    public static final int THREAD_COUNT = 5;

    //线程池的状态
    public Status status = Status.NEW;

    //任务队列
    public TaskQueue queue = new TaskQueue();

    //线程
    public List<Thread> threads = new ArrayList<>();

    public enum Status{
        NEW,
        RUNNING,
        TERMINATED

    }

    public ThreadPoolService(){
        for (int i = 0; i < THREAD_COUNT; i ++){
            Thread t = new TaskThread(this);
            threads.add(t);
        }
    }

    //启动服务
    public void start(){
        this.status = Status.RUNNING;
        for (int i = 0; i < THREAD_COUNT; i ++){
            threads.get(i).start();
        }
    }

    //停止服务
    public void stop(){
        this.status = Status.TERMINATED;
    }

    //是否正在运行
    public boolean isRunning(){
        return this.status == Status.RUNNING;
    }

    //执行任务
    public void runTask(Task task){
        queue.addTask(task);
    }

    protected TaskQueue getTaskQueue(){
        return queue;
    }
}
