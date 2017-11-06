package designmode.factory.factorymethod;

/**
 * Created by xkc on 10/7/16.
 */
public class ChinesePizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("Cheese")){
            return new CheesePizza();
        }else if (type.equals("Bacon")){
            return new BaconPizza();
        }else {
            return null;
        }
    }
}
