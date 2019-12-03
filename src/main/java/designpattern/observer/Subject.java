package designpattern.observer;

import java.util.Vector;

public interface Subject {
    void add(Observer observer);
    void del(Observer observer);
    void notifyObservers();
    void operate();
}
