package observer;

import org.testng.annotations.Test;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class ObserverTest {
    StockGrabber stockGrabber = new StockGrabber();
    StockObserver observer1 = new StockObserver(stockGrabber);
    StockObserver observer2 = new StockObserver(stockGrabber);
    StockObserver observer3 = new StockObserver(stockGrabber);

    @Test
    public void testObservers() {
        stockGrabber.setIbmPrice(98.00);
        stockGrabber.setApplePrice(99.00);
        stockGrabber.setGooglePrice(100.00);
        String testString1 = "1\nIBM: 98.0\nApple: 99.0\nGoogle: 100.0";
        String testString2 = "2\nIBM: 98.0\nApple: 99.0\nGoogle: 100.0";
        String testString3 = "3\nIBM: 98.0\nApple: 99.0\nGoogle: 100.0";
        assertEquals(observer1.getPrices(), testString1);
        assertEquals(observer2.getPrices(), testString2);
        assertEquals(observer3.getPrices(), testString3);
    }

    @Test(dependsOnMethods = "testObservers")
    public void testObserversAfterChange() {
        stockGrabber.setApplePrice(2.00);
        String testString1 = "1\nIBM: 98.0\nApple: 2.0\nGoogle: 100.0";
        String testString2 = "2\nIBM: 98.0\nApple: 2.0\nGoogle: 100.0";
        String testString3 = "3\nIBM: 98.0\nApple: 2.0\nGoogle: 100.0";
        assertEquals(observer1.getPrices(), testString1);
        assertEquals(observer2.getPrices(), testString2);
        assertEquals(observer3.getPrices(), testString3);
    }

    @Test(dependsOnMethods = "testObserversAfterChange")
    public void testUnregister() {
        stockGrabber.unregister(observer3);
        ArrayList<Observer> observers = stockGrabber.getObservers();
        ArrayList<Observer> testArray = new ArrayList<>();
        testArray.add(observer1);
        testArray.add(observer2);
        assertEquals(observers, testArray);
    }
}