package observer;

public interface Observed {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObserver();
}