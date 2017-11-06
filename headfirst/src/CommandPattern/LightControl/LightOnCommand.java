package CommandPattern.LightControl;

import CommandPattern.Command;

/**
 * Created by xkc on 12/7/16.
 */
public class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }
}
