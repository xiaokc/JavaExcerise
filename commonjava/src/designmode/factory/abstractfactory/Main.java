package designmode.factory.abstractfactory;

/**
 * Created by xkc on 10/7/16.
 */
public class Main {
    public static void main(String[] args){
        PizzaStore chinesePizzaStore = new ChinesePizzaStore();
        Pizza pizza = chinesePizzaStore.orderPizza("cheese");
        System.out.println(pizza.getName());
    }
}
