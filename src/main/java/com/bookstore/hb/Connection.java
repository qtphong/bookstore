package com.bookstore.hb;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Connection {

    public static SessionFactory getFactory(){
        SessionFactory factory = null;
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch(HibernateException ex) {
            System.err.println("Could not get session factory: "+ ex);

        }
        return factory;
    }

    public static Session getSession(){
        Session session = null;
        try {
             session = getFactory().openSession();
        } catch(HibernateException ex) {
            System.err.println("Could not create session: "+ ex);
        }
        return session;
    }

    public static Transaction getTransaction(){
        Transaction tx = null;
        try{
            tx = getSession().beginTransaction();
        } catch(HibernateException ex){
            System.err.println("Could not create transaction: "+ ex);
        }
        return tx;
    }

    public static void closeSession(){
        getSession().close();
    }

}
