package designpattern.singleton;

/**
 * @ClassName HungrySingleton
 * @Author will
 * @Date 2019/12/3 11:31 AM
 **/
public class HungrySingleton {
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}

class HungrySingleton1{
    private HungrySingleton1() {}

    private static final HungrySingleton1 hungrySingleton1;
    static {
        hungrySingleton1 = new HungrySingleton1();
    }
    public static HungrySingleton1 getInstance() {
        return hungrySingleton1;
    }
}
