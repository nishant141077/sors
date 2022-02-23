package com.github.nishant141077.sors.repositories;

import java.util.List;
import java.util.Optional;
import org.hibernate.criterion.DetachedCriteria;

public interface IBaseRepository<T> {
  Optional<T> save(T entity);

  Optional<T> getById(String id);

  List<T> select(DetachedCriteria criteria);

  List<T> select(DetachedCriteria criteria, int startRow, int numResults);
}
