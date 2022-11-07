package factory;

public abstract class EnemyShip {
    private String name;
    private double damage;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double newDamage) {
        this.damage =  newDamage;
    }
}