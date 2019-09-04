package com.itheima_04;

import java.util.ArrayList;
import java.util.Collection;

/*
 * foreach:��ǿforѭ����һ�����ڱ������ϻ�������
 * ��ʽ��
 * 		for(Ԫ�ص����� ���� : ���ϻ����������) {
 * 			����ֱ��ʹ�ñ���;
 * 		}
	ע�⣺����ǿforѭ���в����޸ļ��ϣ��������ֲ����޸��쳣��
	
	public interface Iterable<T>
	ʵ������ӿ���������Ϊ "foreach" ����Ŀ�ꡣ

 */
public class ForEachDemo {
    public static void main(String[] args) {
        //�������϶���
        Collection<String> c = new ArrayList<String>();
        //���Ԫ��
        c.add("hello");
        c.add("world");
        c.add("java");

        //��ǿforѭ����������
		/*for(Object obj : c) {
			System.out.println(obj);
		}*/
		
		
		/*for(String s : c) {
			System.out.println(s.toUpperCase());
		}*/

        for (String string : c) {
            c.add("android");
            System.out.println(string);
        }
    }
}
