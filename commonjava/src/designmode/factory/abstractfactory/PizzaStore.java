package designmode.factory.abstractfactory;

/**
 * Created by xkc on 10/7/16.
 */
public abstract class PizzaStore {
    Pizza pizza;
    public Pizza orderPizza(String type){
        pizza = createPizza(type);

        pizza.prepare();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
