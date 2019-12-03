package designpattern.singleton;

/**
 * @ClassName LazyTest
 * @Author will
 * @Date 2019/12/3 12:12 PM
 **/
public class LazyTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ExecutorThread());
        Thread t2 = new Thread(new ExecutorThread());
        t1.start();
        t2.start();
        System.out.println("End");
    }
}
