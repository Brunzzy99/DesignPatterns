package strategy;

import lombok.extern.slf4j.Slf4j;
import strategy.flies.CannotFly;

@Slf4j
public class Dog extends Animal {
    public Dog() {
        super();
        canItFly = new CannotFly();
    }
}