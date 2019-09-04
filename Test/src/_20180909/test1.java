package _20180909;

public class test1 {


    //��� main ����
    public static void main(String[] args) {

        int scores[] = new int[]{89, -23, 64, 91, 119, 52, 73};

        for (int i = 0; i < scores.length; i++) {
            for (int j = scores.length - i - 1; j < scores.length - 1; j++) {
                int temp;
                if (scores[j] < scores[j + 1]) {
                    temp = scores[j + 1];
                    scores[j + 1] = scores[j];
                    scores[j] = temp;
                }
            }

        }
        //���巽����ɳɼ��������ǰ�����Ĺ���       
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }


    }


}
