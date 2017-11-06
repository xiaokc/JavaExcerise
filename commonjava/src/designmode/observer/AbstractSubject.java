package designmode.observer;

/**
 * Created by xkc on 8/21/16.
 */
public interface AbstractSubject {
    void addObserver(AbstractObserver observer);
    void removeObserver(AbstractObserver observer);
    void notifyObservers(String str);
}
