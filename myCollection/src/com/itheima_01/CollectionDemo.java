package com.itheima_01;

import java.util.ArrayList;

/*
 *  ArrayList
 *  ���ϵ���ϵ�ṹ��
 *  	���ڲ�ͬ�����ݽṹ�����ݵ���֯���洢��ʽ��������JavaΪ�����ṩ�˲�ͬ�ļ��ϣ�
 *  	���ǲ�ͬ�ļ������ǵĹ��ܶ������ƣ����ϵ�������ȡ�������Գ�ȡ����������Ǽ�����ϵ�ṹ�γɵ�ԭ��
 *
 *  ��ϵ�ṹ��
 *  		��ôѧϰ?��㿪ʼѧϰ����Ϊ�����������еĹ���
 *  		��ôʹ�ã�ʹ����ײ㣬��Ϊ��ײ���Ǿ����ʵ��
 *
 *  Collection
 *  List
 *  ArrayList
 */
public class CollectionDemo {
    public static void main(String[] args) {
        //�������϶���
        ArrayList al = new ArrayList();
        //���Ԫ��
        al.add("hello");
        al.add("world");
        al.add("java");
        //��������
        for (int x = 0; x < al.size(); x++) {
            System.out.println(al.get(x));
        }

    }
}
