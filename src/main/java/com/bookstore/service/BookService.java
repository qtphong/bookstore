package com.bookstore.service;

import com.bookstore.hb.Connection;
import com.bookstore.model.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.Iterator;
import java.util.List;

public class BookService {
    public Integer addBook(String title, String description){
        Session session = Connection.getSession();
        Transaction tx = null;
        Integer bookId = null;
        try {
            tx = Connection.getTransaction();
            Book book = new Book(title, description);
            bookId = (Integer) session.save(book);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return bookId;
    }

    public void listBook(){
        Session session = Connection.getSession();
        Transaction tx = null;
        try{
            tx = Connection.getTransaction() ;
            List books = session.createQuery("FROM Book").list();
            for(Iterator iterator = ((List) books).iterator(); iterator.hasNext();){
                Book book = (Book) iterator.next();
                System.out.println("Title: " + book.getTitle() );
                System.out.println("Description: " + book.getDescription() );
            }
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void updateTitle(int id, String title){
        Session session = Connection.getSession();
        Transaction tx = null;
        try{
            tx = Connection.getTransaction();
            Book book = session.get(Book.class,id);
            book.setTitle(title);
            session.update(book);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void deleteBook(int id){
        Session session = Connection.getSession();
        Transaction tx = null;
        try{
            tx = Connection.getTransaction();
            Book book = (Book)session.get(Book.class,id);
            System.out.println(book.getTitle());
            session.delete(book);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) {
                System.out.println("Exception occurred");
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            System.out.println("Close anyway");
            session.close();
        }
    }
}
