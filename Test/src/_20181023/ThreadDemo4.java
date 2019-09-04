package _20181023;

/**
 * ��Ȼ���˼���Thread��Ϊʲô��Ҫʵ��Runnable��
 * ����ΪJava��ֻ���Լ̳�һ����
 **/
public class ThreadDemo4 {
    public static void main(String[] args) {
        //method1();
        //�����߳�ʵ��
        MyThread2 thread = new MyThread2(100);
        Thread t3 = new Thread(thread);
        t3.setName("Tom");
        t3.start();
        Thread t4 = new Thread(thread);
        t4.setName("Jerry");
        t4.start();
    }

    private static void method1() {
        //�����߳�ʵ��
        MyThread2 thread2 = new MyThread2(100);
        Thread t = new Thread(thread2);
        t.setName("Kitty");
        //�����߳�
        t.start();

        //�����߳�ʵ��
        MyThread2 thread3 = new MyThread2(200);
        Thread t2 = new Thread(thread3);
        t2.setName("Hello");
        //�����߳�
        t2.start();
    }
}
