package Patterns.builderPattern;

public class Director {
    public static void main(String[] args) {
        Product product = new ProductBuilder().setProductName("Guitar").setAmount(3).createProduct();

        System.out.println(product.toString());
    }
}
