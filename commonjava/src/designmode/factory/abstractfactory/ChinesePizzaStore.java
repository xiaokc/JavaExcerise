package designmode.factory.abstractfactory;

/**
 * Created by xkc on 10/7/16.
 */
public class ChinesePizzaStore extends PizzaStore {
    PizzaIngredientFactory pizzaIngredientFactory = new ChinesePizzaIngredientFactory();
    Pizza pizza;

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")){
            pizza = new CheesePizza(pizzaIngredientFactory);
        }else if(type.equals("bacon")) {
            pizza = new BaconPizza(pizzaIngredientFactory);
        }else {
            pizza = null;
        }
        return pizza;
    }
}
