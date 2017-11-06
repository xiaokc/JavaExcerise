package ObserverPattern;

/**
 * Created by xkc on 1/9/16.
 */
public interface Observer {
    //当气象观测值改变时，主题会把这些状态值当作方法的参数，传递给观察者
    void update(float temp, float humidity, float pressure);
}
