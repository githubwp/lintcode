package designpattern.singleton;

/**
 * @ClassName LazySimpleSingleton
 * @Author will
 * @Date 2019/12/3 12:07 PM
 **/
public class LazySimpleSingleton {
    private LazySimpleSingleton() {}

    private static LazySimpleSingleton lazy;

    public static LazySimpleSingleton getInstance() {
        if (lazy == null) {
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }
}
