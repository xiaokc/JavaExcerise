package designmode.decorator;

/**
 * Created by xkc on 10/5/16.
 */
public class HouseBlend extends Beverage {
    public HouseBlend(){
        description = "House Blend Coffee";
    }
    @Override
    public double cost() {
        return .89;
    }
}
