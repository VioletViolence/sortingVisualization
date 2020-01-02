package Patterns.factoryPattern;

public class MainBuilderClass {

    public static void main(String[] args) {

        CharacterFactory characterFactory = new CharacterFactory();
        var character1 = characterFactory.createCharacter("Orc",20);
        var character2 = characterFactory.createCharacter("Human",10);
        System.out.println(character1.getClass());
        System.out.println(character2.getClass());
    }
}
