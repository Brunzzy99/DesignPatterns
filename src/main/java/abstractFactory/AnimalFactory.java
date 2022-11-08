package abstractFactory;

import abstractFactory.animal.Animal;
import abstractFactory.animal.Dog;
import abstractFactory.animal.Duck;

public class AnimalFactory implements AbstractFactory<Animal> {
    @Override
    public Animal create(String animalType) {
        if ("Dog".equalsIgnoreCase(animalType)) {
            return new Dog();
        }
        else if ("Duck".equalsIgnoreCase(animalType)) {
            return new Duck();
        }
        return null;
    }
}