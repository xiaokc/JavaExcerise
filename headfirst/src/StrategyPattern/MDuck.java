package StrategyPattern;

/**
 * Created by xkc on 12/15/15.
 */
public class MDuck extends Duck{

    public MDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }


    @Override
    public void display() {
        System.out.println("MDuck display yellow");

    }

}
