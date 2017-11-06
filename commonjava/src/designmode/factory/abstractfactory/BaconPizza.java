package designmode.factory.abstractfactory;

/**
 * Created by xkc on 10/7/16.
 */
public class BaconPizza extends Pizza {
    PizzaIngredientFactory pizzaIngredientFactory;
    Dough dough;
    Cheese cheese;
    public BaconPizza(PizzaIngredientFactory pizzaIngredientFactory){
        this.pizzaIngredientFactory = pizzaIngredientFactory;
        name = "bacon";
    }
    @Override
    void prepare() {
        dough = pizzaIngredientFactory.createDough();
        cheese = pizzaIngredientFactory.createCheese();
    }
}
