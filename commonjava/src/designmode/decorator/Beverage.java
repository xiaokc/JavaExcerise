package designmode.decorator;

/**
 * Created by xkc on 10/5/16.
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }
    public abstract double cost();
}
