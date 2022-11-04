package strategy;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import strategy.flies.CanFly;
import strategy.flies.CannotFly;
import strategy.flies.Flies;

@Slf4j
public class StrategyTest {
    private final Animal dog = new Dog();
    private final Animal bird = new Bird();

    @Test
    public void testDefaultInstancesOfCanItFly() {
        assert dog.canItFly instanceof CannotFly;
        assert bird.canItFly instanceof CanFly;
    }

    @Test (dependsOnMethods = "testDefaultInstancesOfCanItFly")
    public void testDoesItHaveFlyingAbility() {
        assert dog.doesItHaveFlyingAbility().equals("Can't fly");
        assert bird.doesItHaveFlyingAbility().equals("Can fly");
    }

    @Test(dependsOnMethods = "testDoesItHaveFlyingAbility")
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

    @Test(dependsOnMethods = "testChangingOfCanItFlyInstance")
    public void testStrategyPatternWithLambda() {
        Flies cannotFly = () -> "Can't fly";
        Flies canFly = () -> "Can fly";
        dog.setFlyingAbility(canFly);
        bird.setFlyingAbility(cannotFly);
        assert dog.doesItHaveFlyingAbility().equals("Can fly");
        assert bird.doesItHaveFlyingAbility().equals("Can't fly");
        dog.setFlyingAbility(cannotFly);
        bird.setFlyingAbility(canFly);
        assert dog.doesItHaveFlyingAbility().equals("Can't fly");
        assert bird.doesItHaveFlyingAbility().equals("Can fly");
    }
}