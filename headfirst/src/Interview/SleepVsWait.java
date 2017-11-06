package Interview;

/**
 * 比较sleep和wait方法的区别
 * Created by xkc on 4/1/16.
 */
public class SleepVsWait {

    public static void main(String[] args){
        new Thread(new Thread1()).start();

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        new Thread(new Thread2()).start();




    }


    static class Thread1 implements Runnable{

        @Override
        public void run() {
            synchronized (SleepVsWait.class){
                System.out.println("Enter thread1");
                System.out.println("thread1 is waiting");

                try {
                    //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                    SleepVsWait.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread1 is going on");
                System.out.println("thread1 is over");


            }

        }
    }

    static class Thread2 implements Runnable{

        @Override
        public void run() {
            synchronized (SleepVsWait.class) {
                System.out.println("Enter thread2");
                System.out.println("thread2 is sleeping");

                //只有针对此对象调用notify()方法后本线程才进入对象锁定池，准备获取对象锁进入运行状态
                //如果把Test.class.notify();注释掉，即Test.class调用了wait方法，而没有调用notify方法，
                //则线程将永远处于挂起状态
                SleepVsWait.class.notify();

                try {
                    //sleep方法导致程序暂停执行指定的时间，让出CPU给其他线程，
                    //但是它的监控状态依然保持着，当指定的时间到了又会自动恢复运行状态
                    //在调用sleep()方法的过程中，线程不会释放对象锁
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread2 is going on");
                System.out.println("thread2 is over");
            }

        }
    }

}
