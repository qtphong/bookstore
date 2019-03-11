package com.bookstore.service;

import com.bookstore.hb.Connection;
import com.bookstore.model.Author;
import com.bookstore.model.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AuthorService {

    public int addAuthor(String name){
        Session session = Connection.getSession();
        Transaction tx = null;
        Integer id = null;

        try{
            tx = Connection.getTransaction();
            Author author = new Author();
            author.setName(name);
            id = (Integer)session.save(author);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        }finally {
            session.close();
        }

        return id;
    }

    public void deleteAuthor(int id){
        Session session = Connection.getSession();
        Transaction tx = null;
        try{
            tx = Connection.getTransaction();
            Author author = session.get(Author.class, id);
            session.delete(author);
            tx.commit();
        }catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void listAuthor(){
        Session session = Connection.getSession();
        Transaction tx = null;
        try{
            tx = Connection.getTransaction();
            List authors = session.createQuery("FROM Author").list();
            for(Iterator iterator = ((List) authors).iterator(); iterator.hasNext();){
                Author author = (Author) iterator.next();
                System.out.println("Author id: " + author.getId());
                System.out.println("Author name: "+ author.getName());
                Set books = author.getBooks();
                for(Iterator iterator1 =  books.iterator(); iterator1.hasNext();){
                    Book book = (Book) iterator1.next();
                    System.out.println("Book name: "+ book.getTitle());
                }

            }
        }catch (HibernateException ex){
            if(tx != null) tx.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }
}
