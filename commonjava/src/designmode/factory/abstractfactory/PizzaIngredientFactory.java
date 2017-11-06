package designmode.factory.abstractfactory;

/**
 * Created by xkc on 10/7/16.
 */
public interface PizzaIngredientFactory {
    Dough createDough();

    Cheese createCheese();
}
