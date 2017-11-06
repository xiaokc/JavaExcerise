package CommandPattern.GarageDoorControl;

import CommandPattern.Command;

/**
 * Created by xkc on 12/7/16.
 */
public class GarageDoorOpenCommand implements Command {
    private GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}
