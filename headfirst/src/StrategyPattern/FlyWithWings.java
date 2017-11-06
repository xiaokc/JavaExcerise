package StrategyPattern;

/**
 * Created by xkc on 12/15/15.
 */
public class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("fly with wings");
    }
}
