package com.itheima_01;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 	Collection
 * 			boolean add(E e)
 * 			void clear()
 * 			boolean contains(Object o)
 * 			boolean isEmpty()
 * 			boolean remove(Object o)
 * 			int size()
 * 			Object[] toArray()


 *
 *
 * Iterator<E> iterator()

 *
 */
public class CollectionDemo2 {
    public static void main(String[] args) {
        //�������϶���
        //Collection c = new Collection();//Collection�ǽӿڣ�����ʵ����
        Collection c = new ArrayList();//��̬����������ָ���������

        //boolean add(E e)
        System.out.println(c.add("hello"));//��Զ������ӳɹ�����ΪArrayList�������ظ�
        System.out.println(c.add("world"));

        //void clear()����ռ���
        //c.clear();

        //boolean contains(Object o)  :�жϼ������Ƿ����ָ��Ԫ��
        //System.out.println(c.contains("java"));

        //boolean isEmpty() :�Ƿ�Ϊ��
        //System.out.println(c.isEmpty());


        //boolean remove(Object o) :ɾ��Ԫ��
        //System.out.println(c.remove("java"));

        //int size() :���ؼ����е�Ԫ�ظ���
        //System.out.println(c.size());

        //Object[] toArray()  :������ת����һ��Object���͵�����
        Object[] objs = c.toArray();
        for (int i = 0; i < objs.length; i++) {
            System.out.println(objs[i]);
        }


        System.out.println(c);
    }
}
