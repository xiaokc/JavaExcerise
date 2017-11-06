package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xkc on 1/9/16.
 */
public class WeatherData implements Subject {
    private List<Observer> observers;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer o) {
        //注册观察者，将该观察者添加到观察者列表的尾部
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        //观察者取消注册，从列表中将其删除
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(o);
        }
    }

    /**
     * 将状态告诉每一个观察者，由于每个观察者都实现了update方法，因此通过调用update方法通知所有观察者
     */
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i ++){
            Observer observer = observers.get(i);
            observer.update(temp,humidity,pressure);
        }
    }

    //当从气象站得到更新观测值时，通知观察者
    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temp, float humidity, float pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
