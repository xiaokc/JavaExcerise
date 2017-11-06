package designmode.singleinstance;

/**
 * 饿加载
 * Created by xkc on 8/21/16.
 */
public class HungryClass {
    private static HungryClass instance = new HungryClass();
    private HungryClass(){

    }

    public static HungryClass getInstance(){
        return instance;
    }
}
