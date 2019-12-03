package designpattern.singleton;

/**
 * @ClassName LazyDoubleCheckSingleton
 * @Author will
 * @Date 2019/12/3 12:37 PM
 **/
public class LazyDoubleCheckSingleton {
    private LazyDoubleCheckSingleton(){}

    private static LazyDoubleCheckSingleton singleton;

    public static LazyDoubleCheckSingleton getInstance() {
        if (singleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
