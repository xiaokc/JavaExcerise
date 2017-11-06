package designmode.decorator;

/**
 * Created by xkc on 10/5/16.
 */
public class Milk extends CondimentDecorator {
    private Beverage beverage;
    public Milk(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+", Milk";
    }

    @Override
    public double cost() {
        return .2+ beverage.cost();
    }
}
