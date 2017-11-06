package StrategyPattern;

/**
 * Created by xkc on 1/8/16.
 */
public class ModelDuck extends Duck {
    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }
    @Override
    public void display() {

    }
}
