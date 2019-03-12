package com.bookstore.service;

import com.bookstore.model.Author;
import java.util.List;

public interface AuthorServiceV2 {

  void addNewAuthor(Author author);

  void deleteAuthor(Author author);

  void updateAuthor(Author author);

  List<Author> getListAuthor();

}
