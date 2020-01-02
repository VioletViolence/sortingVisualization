package Patterns.factoryPattern;

import Patterns.factoryPattern.CharacterTypes.*;

public class CharacterFactory {

    public GenericCharacter createCharacter(String type,int health){
        switch (type.toLowerCase()){
            case "elf": return new Elf(health);
            case "human": return new Human(health);
            case "dwarf": return new Dvarf(health);
            case "goblin": return new Goblin(health);
            case "orc": return new Orc(health);
        }
        System.out.println("Error, unknown race");
        return null;
    };

}
