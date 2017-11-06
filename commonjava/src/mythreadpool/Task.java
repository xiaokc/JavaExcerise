package mythreadpool;

/**
 * Created by xkc on 9/19/16.
 */
public abstract class Task {
    public enum State{
        NEW,
        RUNNING,
        FINISHED
    }

    public State state = State.NEW;

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return this.state;
    }

    public abstract void deal();
}
