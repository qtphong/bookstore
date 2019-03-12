package com.bookstore.service;

import com.bookstore.model.Book;
import java.util.List;

public interface BookServiceV2 {

  void addNewBook(Book book);

  void deleteBook(Book book);

  void updateBook(Book book);

  List<Book> getListBook();

  List<Book> getBookByName(String name);

}
