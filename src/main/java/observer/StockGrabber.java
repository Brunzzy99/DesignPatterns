package observer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class StockGrabber implements Observed {
    private final ArrayList<Observer> observers;
    private double ibmPrice;
    private double applePrice;
    private double googlePrice;

    public StockGrabber() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        observers.remove(deleteObserver);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers) {
            observer.update(ibmPrice, applePrice, googlePrice);
        }
    }

    public void setIbmPrice(double newIbmPrice) {
        this.ibmPrice = newIbmPrice;
        notifyObserver();
    }

    public void setApplePrice (double newApplePrice) {
        this.applePrice = newApplePrice;
        notifyObserver();
    }

    public void setGooglePrice(double newGooglePrice) {
        this.googlePrice = newGooglePrice;
        notifyObserver();
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }
}