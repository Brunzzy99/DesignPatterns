package prototype;

import org.testng.annotations.Test;
import prototype.withCloneable.CloneFactory;
import prototype.withCloneable.Dog;
import prototype.withoutCloneable.Tree;

public class PrototypeTest {
    @Test
    public void testPrototypeWithCloneable() {
        CloneFactory animalMaker = new CloneFactory();
        Dog dog1 = new Dog();
        Dog cloneDog = (Dog) animalMaker.getClone(dog1);
        assert dog1.getLegs() == cloneDog.getLegs();
        assert dog1.hashCode() != cloneDog.hashCode();
    }

    @Test
    public void testPrototypeWithoutCloneable() {
        Tree tree1 = new Tree("Green", 4);
        Tree tree2 = (Tree) tree1.copy();

        assert tree1.getColor().equals(tree2.getColor());
        assert tree1.getHeight() == tree2.getHeight();
        assert tree1.hashCode() != tree2.hashCode();
    }
}