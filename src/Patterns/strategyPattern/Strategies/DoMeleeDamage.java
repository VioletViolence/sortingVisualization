package Patterns.strategyPattern.Strategies;

import java.util.Random;

public class DoMeleeDamage implements IDoDamage {

    @Override
    public int rollForDamage() {
        Random a = new Random();
        int dice = a.nextInt(20)+1;
        if(dice == 20){
            boolean roll = rollForEffect(20);
            if(roll) return 40;
        }
        return dice;
    }

    @Override
    public boolean rollForEffect(int possibilityPercentage) {
        Random rand = new Random();
        int dice = rand.nextInt(100) + 1;
        if(dice >= possibilityPercentage) return true;
        else return false;
    }
}
