package com.bookstore.service;

import java.util.List;

public interface GenericService<T> {

  void addOrUpdate(T object);

  void delete(T object);

  List<T> getList();

}
