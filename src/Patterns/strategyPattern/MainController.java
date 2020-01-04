package Patterns.strategyPattern;

import Patterns.strategyPattern.Strategies.DoMeleeDamage;
import Patterns.strategyPattern.Strategies.DoRangeDamage;
import Patterns.strategyPattern.Strategies.IDoDamage;

import java.util.Random;

public class MainController {

    static int doDamage(IDoDamage behaviour){
        return behaviour.rollForDamage();
    }

    public static void main(String[] args) {
        Random random = new Random();
        if(random.nextBoolean()){
            MainController.doDamage(new DoMeleeDamage());
        }
        else{
            MainController.doDamage(new DoRangeDamage());
        }
    }

}
