package servletCartDemo.entity;

/**
 * 商品实体类
 * Created by xkc on 8/21/15.
 */
public class Item {
    private int id;//商品编号
    private String name;//商品名称
    private String city;//产地
    private int price;//价格
    private int number;//库存
    private String picture;//商品图片

    public Item(){

    }

    public Item(int id, String name, String city, int price, int number, String picture){
        this.id = id;
        this.name = name;
        this.city = city;
        this.picture = picture;
        this.price = price;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    @Override
    public String toString() {
        return "商品编号:"+this.getId()+"，商品名称："+this.getName();
    }

    /**
     * 重写equals方法和hashCode方法以避免购物车中加入重复商品
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }else {
            if(obj instanceof Item){
                Item item = (Item) obj;
                if (this.getId() == item.getId() && this.getName().equals(item.getName())){
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }

        }
    }

    /**
     * 重写equals方法和hashCode方法以避免购物车中加入重复商品
     * @return 保证相同商品的hashCode相同
     */
    @Override
    public int hashCode() {
        return this.getId()+this.getName().hashCode();
    }
}
