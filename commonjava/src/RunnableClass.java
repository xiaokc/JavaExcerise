/**
 * Runnable实现卖票程序，资源可以共享
 * Created by xkc on 8/19/16.
 */
public class RunnableClass implements Runnable {
    private int tickets = 5;
    private String name;
    public RunnableClass(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i ++){
            if (tickets > 0){
                System.out.println("Thread " + name + " sell ticket " + (tickets --));
            }

        }

    }


    public static void main(String[] args){
        RunnableClass A = new RunnableClass("A");//实例化线程要执行的任务
        Thread ta = new Thread(A);//实例化两个线程对象，实际传递的是一个任务
        Thread tb = new Thread(A);//因为两个线程执行同一个任务，所以资源是共享的

        ta.start();
        tb.start();
    }
}
