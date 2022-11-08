package abstractFactory;

import abstractFactory.animal.Animal;
import abstractFactory.animal.Dog;
import abstractFactory.animal.Duck;
import abstractFactory.color.Black;
import abstractFactory.color.Color;
import abstractFactory.color.White;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class AbstractFactoryTest {
    @Test
    public void testFactoryProvider() {
        assert FactoryProvider.getFactory("color") instanceof ColorFactory;
        assert FactoryProvider.getFactory("animal") instanceof AnimalFactory;
        assert FactoryProvider.getFactory("testWrongString") == null;
    }

    @Test
    public void testAnimalFactory() {
        assert new AnimalFactory().create("Dog") instanceof Dog;
        assert new AnimalFactory().create("Duck") instanceof Duck;
        assert new AnimalFactory().create("testWrongString") == null;
    }

    @Test
    public void testColorFactory() {
        assert new ColorFactory().create("White") instanceof White;
        assert new ColorFactory().create("Black") instanceof Black;
        assert new ColorFactory().create("testWrongString") == null;
    }

    @Test
    public void testInstances() {
        var animalFactory = FactoryProvider.getFactory("Animal");
        var colorFactory = FactoryProvider.getFactory("Color");
        Animal animal = (Animal) animalFactory.create("Dog");
        Color color = (Color) colorFactory.create("White");
        assert animal.getAnimal().equals("Dog");
        assert animal.makeSound().equals("Woof");
        assert color.getColor().equals("White");
    }
}