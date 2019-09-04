package com.itheima_07;

import java.util.ArrayList;
import java.util.List;

/*
 * ���󣺶���һ������������ָ���б���ָ��Ԫ�ص�����λ��
 *
 * �ж�Ԫ���Ƿ����
 *
 */
public class ListTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("java");

        //int index = index(list,"php");
        //System.out.println(index);

        //boolean flag = contains(list, "php");
        //System.out.println(flag);

        boolean flag = list.contains("php");
        System.out.println(flag);
    }

    public static int index(List list, Object other) {
        for (int x = 0; x < list.size(); x++) {
            //��ȡ�б��е�Ԫ��
            Object obj = list.get(x);
            //ʹ���б��е�Ԫ�غ�ָ����Ԫ�ؽ��бȽ�
            if (obj.equals(other)) {
                return x;
            }
        }
        //���Ҳ���ָ����Ԫ��
        return -1;
    }

    public static boolean contains(List list, Object other) {
        //��ȡָ��Ԫ����ָ���б��е�����λ��
        int index = index(list, other);
        //�������λ�ô��ڵ���0������ΪԪ�ش��ڣ����򲻴���
        if (index >= 0) {
            return true;
        } else {
            return false;
        }
    }


}
