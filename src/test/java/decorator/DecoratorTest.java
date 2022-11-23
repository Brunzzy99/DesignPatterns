package decorator;

import org.testng.annotations.Test;

public class DecoratorTest {
    @Test
    public void testDecorator() {
        ChristmasTree tree1 = new BubbleLights(new ChristmasTreeImplementation());
        assert tree1.decorate().equals("Christmas tree with Bubble Lights");
    }
}