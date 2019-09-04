package _20181023;

public class MyThread2 implements Runnable {

    int num;

    public MyThread2(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i + ",num=" + num);
        }
    }

}
