package designmode.factory.abstractfactory;

/**
 * Created by xkc on 10/7/16.
 */
public class CheesePizza extends Pizza {
    PizzaIngredientFactory pizzaIngredientFactory;
    Dough dough;
    Cheese cheese;
    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory){
        this.pizzaIngredientFactory = pizzaIngredientFactory;
        name = "cheese";
    }
    @Override
    void prepare() {
        dough = pizzaIngredientFactory.createDough();
        cheese = pizzaIngredientFactory.createCheese();
    }
}
