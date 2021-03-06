package designmode.factory.abstractfactory;

/**
 * Created by xkc on 10/7/16.
 */
public class ChinesePizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickDough();
    }

    @Override
    public Cheese createCheese() {
        return new WhiteCheese();
    }
}
