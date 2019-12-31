package Patterns.prototypePattern;

public class Main {
    public static void main(String[] args) {
        ClonableProduct clonableProduct = new ClonableProduct("NewNew");
        ClonableProduct secondClone = clonableProduct.clone();
    }
}
