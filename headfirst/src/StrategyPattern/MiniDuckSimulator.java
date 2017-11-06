package StrategyPattern;

/**
 * Created by xkc on 1/8/16.
 */
public class MiniDuckSimulator  {
    public static void main(String[] args){
        MDuck mDuck = new MDuck();
        mDuck.performFly();


        ModelDuck modelDuck = new ModelDuck();
        modelDuck.performFly();

        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly();


    }
}
