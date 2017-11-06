package ObserverPattern;

/**
 * Created by xkc on 1/9/16.
 */
public interface Subject {
    void registerObserver(Observer o);//注册观察者
    void removeObserver(Observer o);//删除观察者
    void notifyObservers();//当主题状态改变时，这个方法会被调用，通知所有的观察者
}
