package designmode.factory.abstractfactory;

/**
 * Created by xkc on 10/7/16.
 */
public class AmericanPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinDough();
    }

    @Override
    public Cheese createCheese() {
        return new SweetCheese();
    }
}
