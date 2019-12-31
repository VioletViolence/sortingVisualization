package Patterns.prototypePattern;

import java.time.LocalDateTime;

public class ClonableProduct implements Cloneable {
    private String name;
    private LocalDateTime timeOfCreation;

    public ClonableProduct(){
        name = "Default";
    }
    public ClonableProduct(String name){
        this.name = name;
    }

    @Override
    public ClonableProduct clone(){
        try {
            return (ClonableProduct) super.clone();
        }
        catch (CloneNotSupportedException err){
            throw new AssertionError();
        }
    }
}
