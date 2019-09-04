package com.itheima_06;

import java.util.LinkedList;

/*
 * List�ĳ������ࣺ
 * 		ArrayList
 * 			�ײ�������ṹ����ѯ�죬��ɾ��
 * 		LinkedList
 * 			�ײ�ṹ��������ѯ������ɾ��
 * 
 * ���ѡ��ʹ�ò�ͬ�ļ��ϣ�
 * 		�����ѯ�࣬��ɾ�٣���ʹ��ArrayList
 * 		�����ѯ�٣���ɾ�࣬��ʹ��LinkedList
 * 		����㲻֪��ʹ��ʲô����ʹ��ArrayList
 * 
 * LinkedList�����й��ܣ�
 * 			void addFirst(E e)  
 * 			void addLast(E e) 
 			E getFirst()  
 			E getLast()  
 			E removeFirst() 
 			E removeLast() 
 * 				
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("hello");
        list.add("world");

        //void addFirst(E e)  :��Ԫ����ӵ�����Ϊ0��λ��
        //void addLast(E e) ����Ԫ����ӵ�����Ϊsize()-1��λ��
        list.addFirst("java");
        list.addLast("android");

        //E getFirst()  :��ȡ����Ϊ0��Ԫ��
        //E getLast()  ����ȡ����Ϊsize()-1��Ԫ��
        //System.out.println(list.getFirst());
        //System.out.println(list.getLast());

        //E removeFirst() :ɾ������Ϊ0��Ԫ�ز�����
        //E removeLast() ��ɾ������Ϊsize()-1��Ԫ�ز�����
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());


        System.out.println(list);
    }
}
