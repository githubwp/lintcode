package designpattern.singleton;

/**
 * @ClassName ExecutorThread
 * @Author will
 * @Date 2019/12/3 12:09 PM
 **/
public class ExecutorThread implements Runnable {
    @Override
    public void run() {
        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
