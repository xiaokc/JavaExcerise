package StrategyPattern;

/**
 * 定义一个抽象超类
 * Created by xkc on 12/15/15.
 */
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior fb){
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb){
        this.quackBehavior = qb;
    }

    public void swim(){
        System.out.println("All duck can swim");
    }
    public abstract void display();
}
