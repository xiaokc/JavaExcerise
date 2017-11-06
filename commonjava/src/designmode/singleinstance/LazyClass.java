package designmode.singleinstance;

/**
 * 懒加载，用的时候加载
 * Created by xkc on 8/21/16.
 */
public class LazyClass {
    private volatile static LazyClass instance;
    private LazyClass(){}

    public static LazyClass getInstance(){
        if (instance == null){
            synchronized (LazyClass.class){
                if (instance == null){
                    instance = new LazyClass();
                }
            }
        }
        return instance;
    }
}
