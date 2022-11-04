package strategy;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import strategy.flies.CanFly;
import strategy.flies.CannotFly;

@Slf4j
public class StrategyTest {
    private final Animal dog = new Dog();
    private final Animal bird = new Bird();

    @Test
    public void testDefaultInstancesOfCanItFly() {
        assert dog.canItFly instanceof CannotFly;
        assert bird.canItFly instanceof CanFly;
    }

    @Test
    public void testDoesItHaveFlyingAbility() {
        assert dog.doesItHaveFlyingAbility().equals("Can't fly");
        assert bird.doesItHaveFlyingAbility().equals("Can fly");
    }

    @Test
    public void testChangingOfCanItFlyInstance() {
        dog.setFlyingAbility(new CanFly());
        bird.setFlyingAbility(new CannotFly());
        assert dog.canItFly instanceof CanFly;
        assert bird.canItFly instanceof CannotFly;
        dog.setFlyingAbility(new CannotFly());
        bird.setFlyingAbility(new CanFly());
        assert dog.canItFly instanceof CannotFly;
        assert bird.canItFly instanceof CanFly;
    }
}