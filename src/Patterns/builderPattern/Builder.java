package Patterns.builderPattern;

public interface Builder {
    Builder setProductName(String productName);

    Builder setManufacturerName(String manufacturerName);

    Builder setPrice(int price);

    Builder setAmount(int amount);
}
