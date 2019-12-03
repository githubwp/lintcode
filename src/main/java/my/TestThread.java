package my;

public class TestThread implements Runnable{
    static int a = 0;
    static int b =1000;
    static int c =3000;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                a++;
                System.out.println(a);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                b++;
                System.out.println(b);
            }
        });
        t1.start();
        t2.start();
        new TestThread().run();
        new TestThread().run();
        new TestThread().run();
        new TestThread().run();
        new TestThread().run();
        new TestThread().run();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            c++;
            System.out.println(c);
        }
    }
}
