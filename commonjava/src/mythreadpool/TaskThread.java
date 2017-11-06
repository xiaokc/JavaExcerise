package mythreadpool;

/**
 * 执行任务的线程
 * Created by xkc on 9/19/16.
 */
public class TaskThread extends Thread{
    private ThreadPoolService service;//该线程所属的线程池
    public TaskThread(ThreadPoolService tps){
        this.service = tps;
    }
    @Override
    public void run() {
        //在线程池运行的状态下执行任务队列的任务
        while (service.isRunning()){
            TaskQueue queue = service.getTaskQueue();
            Task task = queue.getTask();
            if (task != null){
                task.deal();
            }
            queue.finishTask(task);
        }
    }
}
