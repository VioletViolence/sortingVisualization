package Patterns.strategyPattern.Strategies;

import java.util.Random;

public class DoRangeDamage implements IDoDamage{
    @Override
    public int rollForDamage() {
        return 20;
    }

}
