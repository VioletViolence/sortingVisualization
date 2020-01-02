package Patterns.factoryPattern;

import java.util.ArrayList;

public class GenericCharacter{
    int level;
    int health;

    protected GenericCharacter(int health){
        this.health = health;
    }

    public void levelUp(){
        this.level -=- 1;
    }
}
