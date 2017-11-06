package SingletonPattern;

/**巧克力工厂
 * Created by xkc on 3/13/16.
 */
public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    //双重
    private static volatile ChocolateBoiler chocolateBoiler;
    //代码开始前，锅炉是空的
    private ChocolateBoiler(){
        empty = true;
        boiled = false;
    }

    //同步锁
    public static synchronized ChocolateBoiler getInstance(){
        if (chocolateBoiler == null){//懒汉式单利模式，需要的时候创建实例
            chocolateBoiler = new ChocolateBoiler();
        }
        return chocolateBoiler;
    }


    
    public void fill(){
        if (isEmpty()){
            empty = false;
            boiled = false;
            
        }
    }
    public void drain(){
        if (! isEmpty() && isBoiled()){
            empty = true;
        }
    }

    public void boil(){
        if (! isEmpty() && ! isBoiled()){
            boiled = true;
        }
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isBoiled(){
        return boiled;
    }
    
    
}
