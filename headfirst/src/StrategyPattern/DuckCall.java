package StrategyPattern;

/**
 * Created by xkc on 1/8/16.
 */
public class DuckCall implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("I am a duck call decoy the wild duck!");
    }
}
