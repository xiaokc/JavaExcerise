package CommandPattern;

/**
 * Created by xkc on 12/7/16.
 */
public class SimpleRemoteControl {
    private Command slot;
    public SimpleRemoteControl(){

    }
    public void setCommand(Command command){
        this.slot = command;
    }

    public void buttonPressed(){
        slot.execute();
    }
}
