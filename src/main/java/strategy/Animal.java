package strategy;

import strategy.flies.Flies;

public class Animal {
    protected Flies canItFly;

    public String doesItHaveFlyingAbility() {
        return canItFly.fly();
    }

    public void setFlyingAbility(Flies newFlyType) {
        canItFly = newFlyType;
    }
}