package designmode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xkc on 8/21/16.
 */
public class ConcreteSubject implements AbstractSubject {
    private List<AbstractObserver> observers = new ArrayList<>();
    @Override
    public void addObserver(AbstractObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(AbstractObserver observer) {
        if (observers.contains(observer)){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers(String str) {
        for (AbstractObserver observer : observers){
            observer.update(str);
        }
    }
}
