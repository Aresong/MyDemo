package com.s5.hibernate.utils;
/**
 * Hibernate�Ĺ�����
 **/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    public static final Configuration cfg;
    public static final SessionFactory sf;

    static {
        cfg = new Configuration().configure();
        sf = cfg.buildSessionFactory();
    }

    public static Session openSession() {
        return sf.openSession();
    }

    //���̹߳ر�session
    public static Session getCurrentSession() {
        return sf.getCurrentSession();
    }
}
