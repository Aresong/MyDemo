package _20180920;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test1 {
    List<Integer> list;

    public static void main(String[] args) {
        test1 tt1 = new test1();
        tt1.list = new ArrayList<Integer>();
        tt1.list.add(1);
        tt1.list.add(5);
        tt1.list.add(2);
        tt1.list.add(4);
        tt1.list.add(6);
        tt1.list.add(3);

        tt1.list.sort(null);

        for (Integer xxlist : tt1.list) {
            System.out.println(xxlist);
        }

        int search = Collections.binarySearch(tt1.list, 3);
    }
}
