package CommandPattern;

import CommandPattern.GarageDoorControl.GarageDoor;
import CommandPattern.GarageDoorControl.GarageDoorOpenCommand;
import CommandPattern.LightControl.Light;
import CommandPattern.LightControl.LightOnCommand;

/**
 * Created by xkc on 12/7/16.
 */
public class TestMain {
    public static void main(String[] args){
        SimpleRemoteControl remote = new SimpleRemoteControl();

        LightOnCommand lightOn = new LightOnCommand(new Light());

        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(new GarageDoor());


        remote.setCommand(lightOn);
        remote.buttonPressed();

        remote.setCommand(garageDoorOpen);
        remote.buttonPressed();
    }
}
