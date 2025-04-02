package logging_system;

import java.util.ArrayList;
import java.util.List;

public class LogSubject {
    private List<LogObserver> observers = new ArrayList<>();

    public void addObserver(LogObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (LogObserver observer : observers) {
            observer.update(message);
        }
    }
}
