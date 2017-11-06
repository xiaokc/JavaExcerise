package servletCartDemo.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 购物车类
 * Created by xkc on 8/26/15.
 */
public class Cart {
    //    购物车商品集合
    private Map<Item, Integer> goods;
    //购物车商品总金额
    private double totalPrice;

    public Cart() {
        goods = new HashMap<>();
        totalPrice = 0.0;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Map<Item, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<Item, Integer> goods) {
        this.goods = goods;
    }

    /**
     * 添加商品进购物车
     *
     * @param item
     * @param number
     * @return
     */
    public boolean addItemInCart(Item item, int number) {

        if (goods.containsKey(item)) {
            goods.put(item, goods.get(item) + number);
        } else {
            goods.put(item, number);
        }

        calTotalPrice();//重新计算购物车总金额
        return true;

    }

    /**
     * 从购物车删除商品
     */
    public boolean removeItemFromCart(Item item) {
        goods.remove(item);
        calTotalPrice();//重新计算购物车总金额
        return true;
    }


    /**
     * 统计购物车商品总金额
     * @return
     */
    public double calTotalPrice() {
        double sum = 0.0;
        Set<Map.Entry<Item, Integer>> entrySet = goods.entrySet();
        Iterator<Map.Entry<Item, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Item, Integer> entry = iterator.next();
            Item item = entry.getKey();
            int number = entry.getValue();

            sum += item.getPrice() * number;
            this.setTotalPrice(sum);//设置总金额
        }
        return this.getTotalPrice();
    }



    //测试
    public static void main(String[] args) {
        Item item1 = new Item(1, "沃特篮球鞋", "佛山", 180, 200, "001.jpg");
        Item item2 = new Item(2, "李宁运动鞋", "广州", 200, 500, "002.jpg");
        Item item3 = new Item(1, "沃特篮球鞋", "佛山", 180, 200, "001.jpg");

        Cart cart = new Cart();
        cart.addItemInCart(item1, 1);
        cart.addItemInCart(item2, 2);
        cart.addItemInCart(item3, 3);//再次购买沃特篮球鞋

        //遍历购物车
        Map<Item, Integer> goods = cart.getGoods();
        Set<Map.Entry<Item, Integer>> entrySet = goods.entrySet();
        for (Map.Entry<Item, Integer> obj : entrySet) {
            System.out.println(obj);
        }

        System.out.println(cart.getTotalPrice());

    }


}
