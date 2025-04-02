package TASK4_1;

import java.util.ArrayList;
import java.util.List;

public class AuctionItem implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String itemName;

    public AuctionItem(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    public String getItemName() {
        return itemName;
    }
}
