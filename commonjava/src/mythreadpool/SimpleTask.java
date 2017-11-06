package mythreadpool;

/**
 * Created by xkc on 9/19/16.
 */
public class SimpleTask extends Task {
    @Override
    public void deal() {

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolService service = new ThreadPoolService();
        service.start();

        //执行10次任务
        for (int i = 0; i < 10; i ++){
            service.runTask(new SimpleTask());
        }

        //睡眠1秒钟，等待所有任务执行完毕
        Thread.sleep(1000);
        service.stop();
    }
}
