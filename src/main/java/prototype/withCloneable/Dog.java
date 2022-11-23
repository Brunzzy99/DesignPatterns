package prototype.withCloneable;

public class Dog implements Animal {
    int legs = 4;

    public int getLegs() {
        return legs;
    }

    @Override
    public Animal makeCopy() {
        Dog dogClone;
        try {
            dogClone = (Dog) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return dogClone;
    }
}