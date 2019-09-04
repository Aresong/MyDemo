package _20180928;

public class test1 {

    private int i = 5;

    private int jc(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * jc(n - 1);
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //method1();
        test1 test = new test1();
        System.out.println(test.jc(5));
    }

    private static void method1() {
        test1 test = new test1();
        int sum = 1;
        for (int j = test.i; j > 0; j--) {
            sum *= j;
        }
        System.out.println(sum);
    }

}
