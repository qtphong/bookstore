package com.bookstore.service;

import static com.bookstore.hb.HibernateUtils.getSession;

import com.bookstore.model.Book;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class BookServiceImpl extends AbstractGenericService<Book> implements BookServiceV2 {

  public void addNewBook(Book book) {
    addOrUpdate(book);
  }

  public void deleteBook(Book book) {
    delete(book);
  }

  public void updateBook(Book book) {
    addOrUpdate(book);
  }

  public List<Book> getListBook() {
    return getList();
  }

  public List<Book> getBookByName(String name) {
    Criteria cr = getSession().createCriteria(Book.class);
    cr.add(Restrictions.like("title", String.format("%s%", name)));
    return cr.list();
  }
}
