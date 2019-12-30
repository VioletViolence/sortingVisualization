package Patterns.builderPattern;

public class ProductBuilder implements Builder{
    private String productName;
    private String manufacturerName;
    private int price;
    private int amount;

    @Override
    public ProductBuilder setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    @Override
    public ProductBuilder setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
        return this;
    }

    @Override
    public ProductBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public ProductBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public Product createProduct() {
        return new Product(productName, manufacturerName, price, amount);
    }
}