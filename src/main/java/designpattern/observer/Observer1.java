package designpattern.observer;

import java.util.LinkedList;

public class Observer1 implements Observer {

    @Override
    public void update() {
        System.out.println("observer1 received message");
    }
}
