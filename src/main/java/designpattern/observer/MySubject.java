package designpattern.observer;

public class MySubject extends AbstractSubject {
    @Override
    public void operate() {
        System.out.println("mySubject was operated!");
        notifyObservers();
    }
}
