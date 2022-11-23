package factory;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactoryTest {
    private final EnemyShipFactory shipFactory = new EnemyShipFactory();

    @Test
    public void testFactoryForUfoEnemyShip() {
        EnemyShip ufoEnemyShip = shipFactory.makeEnemyShip("U");
        assert ufoEnemyShip instanceof UFOEnemyShip;
        assertEquals(ufoEnemyShip.getName(), "UFO Enemy Ship");
        assertEquals(ufoEnemyShip.getDamage(), 20.0);
    }

    @Test
    public void testFactoryForRocketEnemyShip() {
        EnemyShip rocketEnemyShip = shipFactory.makeEnemyShip("R");
        assert rocketEnemyShip instanceof RocketEnemyShip;
        assertEquals(rocketEnemyShip.getName(), "Rocket Enemy Ship");
        assertEquals(rocketEnemyShip.getDamage(), 10.0);
    }
}