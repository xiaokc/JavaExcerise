/**
 * Thread实现卖票程序，不能共享资源
 * Created by xkc on 8/19/16.
 */
public class ThreadClass extends Thread {
    private int tickets = 5;
    private String name;

    public ThreadClass(String name){
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
        ThreadClass A = new ThreadClass("A");//两个线程各自卖票
        ThreadClass B = new ThreadClass("B");
        A.start();
        B.start();
    }

}
