package designmode.decorator;

/**
 * Created by xkc on 10/5/16.
 */
public class Main {
    public static void main(String[] args){
        Beverage beverage = new HouseBlend();
        beverage = new Milk(beverage);
        System.out.println(beverage.cost());
    }
}
