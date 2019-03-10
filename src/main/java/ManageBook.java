import java.lang.Throwable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;


import java.util.Iterator;
import java.util.List;

public class ManageBook {
    private static SessionFactory factory;
    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        }catch(Throwable ex) {
            System.err.println("Fail to create session factory object. " + ex);
            throw new ExceptionInInitializerError(ex);
        }

        ManageBook mb  = new ManageBook();
//        mb.addBook("Book 1","Book 1 description");
        mb.addBook("Book 2", "Book 2 description");
        mb.listBook();
//        mb.updateTitle(1,"Book 1 edited");
//        mb.deleteBook(2);

    }

    public Integer addBook(String title, String description){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer bookId = null;
        try {


            tx = session.beginTransaction();
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
        Session session = factory.openSession();
        Transaction tx = null;
        try{
           tx = session.beginTransaction();
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
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Book book = (Book)session.get(Book.class,id);
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
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Book book = session.get(Book.class,id);
            session.delete(book);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}


