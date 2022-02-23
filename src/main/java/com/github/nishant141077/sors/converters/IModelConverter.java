package com.github.nishant141077.sors.converters;

/**
 * Converts between dao and dto
 *
 * @param <T>
 * @param <U>
 */
public interface IModelConverter<T, U> {

  U toDto(T dao);

  T toDao(U dto);
}
