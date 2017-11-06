package designmode.factory.factorymethod;

/**
 * Created by xkc on 10/7/16.
 */
public class Main {
    public static void main(String[] args){
        ChinesePizzaStore chinesePizzaStore = new ChinesePizzaStore();
        Pizza pizza = chinesePizzaStore.orderPizza("Bacon");
        System.out.println("Pizza name is:" + pizza.getName());

    }
}
