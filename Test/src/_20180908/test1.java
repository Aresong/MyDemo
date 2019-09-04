package _20180908;

public class test1 {

    //�ⲿ���˽������name
    private static String name = "imooc";

    //�ⲿ��ĳ�Ա����
    int age = 20;

    //��Ա�ڲ���Inner
    public class Inner {
        String name = "��Ľ��";

        //�ڲ����еķ���
        public void show() {
            System.out.println("�ⲿ���е�name��" + this.name);
            System.out.println("�ڲ����е�name��" + name);
            System.out.println("�ⲿ���е�age��" + age);
        }
    }

    //���Գ�Ա�ڲ���
    public static void main(String[] args) {

        //�����ⲿ��Ķ���
        test1 o = new test1();

        //�����ڲ���Ķ���
        Inner inn = o.new Inner();

        //�����ڲ�������show����
        inn.show();
    }
}