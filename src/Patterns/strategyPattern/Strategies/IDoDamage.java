package Patterns.strategyPattern.Strategies;

import java.util.Random;

public interface IDoDamage {
    int rollForDamage();
     default boolean rollForEffect(int possibilityPercentage) {
        Random a = new Random();
        int dice = a.nextInt(20)+1;
        if(dice > 15) return true;
        return false;
    }
}
