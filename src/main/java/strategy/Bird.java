package strategy;

import strategy.flies.CanFly;

public class Bird extends Animal {
    public Bird() {
        super();
        canItFly = new CanFly();
    }
}