package designpattern.singleton;

/**
 * 这种模式兼顾饿汉式单例模式的内存浪费问题和synchronize的性能问题，完美的屏蔽了这两个缺点
 * 如果LazyInnerClassSingleton没有被使用，则内部类是不加载的，如果使用了，则默认会先初始化内部类
 * @ClassName LazyInnerClassSingleton
 * @Author will
 * @Date 2019/12/3 12:45 PM
 **/
public class LazyInnerClassSingleton {
    private LazyInnerClassSingleton(){
        if (LazyHolder.LAZY != null) {
            //防止反射破坏单例
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    public static final LazyInnerClassSingleton getInstance() {
        //返回结果前，一定会先加载内部类
        return LazyHolder.LAZY;
    }

    //默认不加载
    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
    // 防止序列化破坏单例
    private Object readResolve() {
        return LazyHolder.LAZY;
    }
}
