package com.itheima_02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * �����жϼ������Ƿ����Ԫ��java������������Ԫ��android
 * Exception in thread "main" java.util.ConcurrentModificationException:�����޸��쳣
 * �������������ڼ��ϵģ��൱�ڼ��ϵ�һ�����������������ڲ�����ʱ��������ֺͼ��ϲ�һ�������׳��쳣
 *
 * �������:
 * 		��ͱ�ʹ�õ�����
 * 		��ʹ�õ��������б�����ʱ��ʹ�õ������������޸�
 */
public class IteratorDemo3 {
    public static void main(String[] args) {
        //method();

        //�������϶���
        //Collection c = new ArrayList();
        List c = new ArrayList();
        //���Ԫ��
        c.add("hello");
        c.add("world");
        c.add("java");

        //���ǿ���ͨ����������ȡ�����е�ÿһ��Ԫ�أ�Ȼ����бȽϼ���
		/*Iterator it = c.iterator();
		while(it.hasNext()) {
			String s = (String)it.next();
			if(s.equals("java")) {
				c.add("android");
			}
		}*/

        ListIterator lit = c.listIterator();
        while (lit.hasNext()) {
            String s = (String) lit.next();
            if (s.equals("java")) {
                lit.add("android");
            }
        }

        System.out.println(c);

    }

    private static void method() {
        //�������϶���
        Collection c = new ArrayList();
        //���Ԫ��
        c.add("hello");
        c.add("world");
        c.add("java");
        //�жϼ������Ƿ����Ԫ��java
        if (c.contains("java")) {
            c.add("android");
        }

        System.out.println(c);
    }


}
