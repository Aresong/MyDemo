package com.itheima_05;

import java.util.ArrayList;
import java.util.List;

/*
 * List:
 * 		����ģ��洢�Ͷ�ȡ��˳����һ�µģ�
 * 		����������
 * 		�����ظ���
 *
 * List�����й��ܣ�
 * 			void add(int index, E element)
 * 			E get(int index)
 * 			E remove(int index)
 *  		E set(int index, E element)
 *
 *   ��ɾ�Ĳ�


 *
 */
public class ListDemo {
    public static void main(String[] args) {
        //�������б����
        List list = new ArrayList();

        //void add(int index, E element)  : ��ָ������λ�����ָ��Ԫ��
        list.add(0, "hello");
        list.add(0, "world");
        list.add(1, "java");

        //E get(int index)  :������������Ԫ��
		/*System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));*/
        //System.out.println(list.get(3));
		
		/*for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}*/

        //E remove(int index)  : ɾ��ָ��Ԫ�ز�����

        //System.out.println(list.remove(5));

        //E set(int index, E element) : ��ָ������λ�õ�Ԫ���滻Ϊָ��Ԫ�أ�����ԭ�ȵ�Ԫ�ط���
        System.out.println(list.set(0, "android"));

        System.out.println(list);
    }
}
