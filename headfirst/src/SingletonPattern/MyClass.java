package SingletonPattern;

/**
 *
 * Created by xkc on 3/13/16.
 */
public class MyClass {
    private MyClass(){}
    public static MyClass getInstance(){
        return new MyClass();
    }
}
