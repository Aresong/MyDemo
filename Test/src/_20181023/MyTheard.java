package _20181023;

/**
 * ����һ���߳�����߳̾ͻ�ִ��run�����еĴ���
 **/
public class MyTheard extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i);
        }
    }
}
