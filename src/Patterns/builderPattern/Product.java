package Patterns.builderPattern;

public class Product {

    private String productName;
    private String manufacturerName;
    private int price;
    private int amount;

    public Product(String productName, String manufacturerName, int price, int amount){
        this.productName = productName;
        this.amount = amount;
        this.price = price;
        this.manufacturerName = manufacturerName;
    }

    @Override
    public String toString(){
        if(manufacturerName != null) return "Product name is " + productName + "; Amount is " + amount + "; Manufacturer: " + manufacturerName + "; Price: " + price;
        else return "Product name is " + productName + "; Amount is " + amount + "; Manufacturer: Unknown" + "; Price: " + price;
    }
}
