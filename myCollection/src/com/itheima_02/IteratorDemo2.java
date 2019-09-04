package com.itheima_02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * ���ϵı�����ʽ��
 * 		1.toArray(),���԰Ѽ���ת�������飬Ȼ��������鼴��
 * 		2.iterator(),���Է���һ���������������ǿ���ͨ����������������������
 *
 * Iterator���������ڱ�������
 * 	E next()  :������һ��Ԫ��
 *  boolean hasNext()  ���ж��Ƿ���Ԫ�ؿ��Ի�ȡ
 *
 *  ע�⣺Exception in thread "main" java.util.NoSuchElementException
 *  	ʹ��next������ȡ��һ��Ԫ�أ����û��Ԫ�ؿ��Ի�ȡ�������NoSuchElementException

 */
public class IteratorDemo2 {
    public static void main(String[] args) {
        //method();
        //�������϶���
        Collection c = new ArrayList();
        //���Ԫ��
        c.add("hello");
        c.add("world");
        c.add("java");

        //��ȡ����������
        Iterator it = c.iterator();

        //Object next()  :������һ��Ԫ��
        //boolean hasNext()  ���ж��Ƿ���Ԫ�ؿ��Ի�ȡ
		
		/*if(it.hasNext())
			System.out.println(it.next());
		if(it.hasNext())
			System.out.println(it.next());
		if(it.hasNext())
			System.out.println(it.next());
		if(it.hasNext())
			System.out.println(it.next());*/

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static void method() {
        //�������϶���
        Collection c = new ArrayList();
        //���Ԫ��
        c.add("hello");
        c.add("world");
        c.add("java");
        //��ȡ����
        Object[] objs = c.toArray();
        //��������
        for (int i = 0; i < objs.length; i++) {
            System.out.println(objs[i]);
        }
    }


}
