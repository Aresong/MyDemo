package _20181023;

/**
 * CPUִ���߳�������ģ�������ִ���ĸ�Ҳ��ȷ��
 **/
public class TreadDemo {
    public static void main(String[] args) {
        //�����߳�ʵ��
        MyTheard mt = new MyTheard();
        //�޸��߳�����
        mt.setName("tom");
        //�����߳�
        mt.start();
        //�����߳�ʵ��
        MyTheard mt2 = new MyTheard();
        //�޸��߳�����
        mt2.setName("jerry");
        //�����߳�
        mt2.start();
    }
}
