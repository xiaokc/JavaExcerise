package StrategyPattern;

/**
 * Created by xkc on 12/15/15.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack sound is quack");
    }
}
