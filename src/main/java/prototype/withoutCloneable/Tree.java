package prototype.withoutCloneable;

public class Tree extends Plant {
    private final String color;
    private final int height;

    public Tree(String color, int height) {
        this.color = color;
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public Plant copy() {
        return new Tree(this.getColor(), this.getHeight());
    }
}
