package designmode.factory.abstractfactory;

/**
 * Created by xkc on 10/7/16.
 */
public abstract class Pizza {
    String name;
    public String getName(){
        return name;
    }

    abstract void prepare();
}
