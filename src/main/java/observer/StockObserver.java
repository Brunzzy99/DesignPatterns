package observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StockObserver implements Observer {
    private double ibmPrice;
    private double applePrice;
    private double googlePrice;

    private static int observerIDTracker = 0;

    private final int observerID;

    public StockObserver(Observed stockGrabber) {
        this.observerID = ++observerIDTracker;
        stockGrabber.register(this);
    }
    @Override
    public void update(double ibmPrice, double applePrice, double googlePrice) {
        this.ibmPrice = ibmPrice;
        this.applePrice = applePrice;
        this.googlePrice = googlePrice;
    }

    public String getPrices() {
        return observerID + "\nIBM: " + ibmPrice + "\nApple: " + applePrice + "\nGoogle: " + googlePrice;
    }
}