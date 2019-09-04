package com.itheima_03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * ʹ�ü��ϴ洢�Զ�����󲢱���
 * ���ڼ��Ͽ��Դ洢�������͵Ķ��󣬵����Ǵ洢�˲�ͬ���͵Ķ��󣬾��п�����ת����ʱ���������ת���쳣��
 * ����javaΪ�˽��������⣬�������ṩ��һ�ֻ��ƣ���������
 *
 * ���ͣ���һ�ֹ㷺�����ͣ�����ȷ�������͵Ĺ�����ǰ���˱���ʱ�ڣ������������ص�
 * ���ͺô���
 * 			����������ת��������
 * 			���Լ��ٻ�ɫ������
 * 			���Լ����Ǵ������д
 *
 * ʲôʱ�����ʹ�÷��ͣ�
 * 		��API�������ǿ���<E>���Ϳ���ʹ�÷�����
 *
 */
public class GenericDemo {
    public static void main(String[] args) {
        //�������϶���
        Collection<Student> c = new ArrayList<Student>();
        //����Ԫ�ض���
        Student s = new Student("zhangsan", 18);
        Student s2 = new Student("lisi", 19);
        //���Ԫ�ض���
        c.add(s);
        c.add(s2);
        //�������϶���

        Iterator<Student> it = c.iterator();
        while (it.hasNext()) {
            //String str = (String)it.next();
            //System.out.println(str);

            Student stu = it.next();
            System.out.println(stu.name);
        }
    }
}

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}