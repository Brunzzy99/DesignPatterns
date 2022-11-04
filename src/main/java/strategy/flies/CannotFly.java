package strategy.flies;

public class CannotFly implements Flies {
    @Override
    public String fly() {
        return "Can't fly";
    }
}