package designmode.observer;

/**
 * Created by xkc on 8/21/16.
 */
public class ConcreteObserver implements AbstractObserver {
    private AbstractSubject subject;

    public ConcreteObserver() {
    }

    public ConcreteObserver(AbstractSubject subject) {
        this.subject = subject;
    }

    public void subscribe(){
        if (subject != null){
            subject.addObserver(this);
        }else {
            try {
                throw new Exception("Please create subject first!");
            } catch (Exception e) {
                System.out.println("Throw Exception Error.");
            }
        }
    }

    public void cancelSubscribe(){
        if (subject != null){
            subject.removeObserver(this);
        }else {
            try {
                throw new Exception("Please create subject first!");
            } catch (Exception e) {
                System.out.println("Throw Exception Error.");
            }
        }
    }

    @Override
    public void update(String str) {
        System.out.println(str);
    }
}
