package StrategyPattern;

/**
 * Created by xkc on 1/8/16.
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can fly in rocket power!");
    }
}
