package com.bookstore.service;

import com.bookstore.hb.HibernateUtils;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AbstractGenericService<T> implements GenericService<T> {

  private Class<T> entityClass;

  public AbstractGenericService() {
    this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
        .getActualTypeArguments()[0];
  }

  protected Session getSesison() {
    return HibernateUtils.getSession();
  }

  public void addOrUpdate(T object) {
    Session session = HibernateUtils.getSession();
    Transaction tx = null;
    try {
      tx = HibernateUtils.getTransaction();
      session.saveOrUpdate(object);
      tx.commit();
      System.out.println("Save or update success!!");
    } catch (HibernateException e) {
      if (tx != null) {
        tx.rollback();
      }
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  public void delete(T object) {
    Session session = HibernateUtils.getSession();
    Transaction tx = null;
    try {
      tx = HibernateUtils.getTransaction();
      session.delete(object);
      tx.commit();
      System.out.println("Delete success!!");
    } catch (HibernateException e) {
      if (tx != null) {
        System.out.println("Exception occurred");
        tx.rollback();
      }
      e.printStackTrace();
    } finally {
      System.out.println("Close anyway");
      session.close();
    }

  }

  public List<T> getList() {
    Session session = HibernateUtils.getSession();
    Transaction tx = null;
    List<T> result = null;
    try{
      tx = HibernateUtils.getTransaction() ;
      result = session.createCriteria(this.entityClass).list();
      for(T object : result) {
        System.out.println(object);
      }
    }catch(HibernateException e){
      if(tx != null) tx.rollback();
      e.printStackTrace();
    }finally {
      session.close();
    }
    return result;
  }
}
