package com.bookstore.service;

import com.bookstore.model.Author;
import java.util.List;

public class AuthorServiceImpl extends AbstractGenericService<Author> implements AuthorServiceV2 {

  public void addNewAuthor(Author author) {
    addOrUpdate(author);
  }

  public void deleteAuthor(Author author) {
    delete(author);
  }

  public void updateAuthor(Author author) {
    addOrUpdate(author);
  }

  public List<Author> getListAuthor() {
    return getList();
  }
}
