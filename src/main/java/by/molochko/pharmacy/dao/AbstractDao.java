package by.molochko.pharmacy.dao;

import java.util.List;

import by.molochko.pharmacy.exception.DAOException;

public interface AbstractDao<T> {

	List<T> findAll() throws DAOException;

	T findEntityById(Integer id) throws DAOException;

	boolean delete(Integer id) throws DAOException;

	boolean delete(T entity) throws DAOException;

	boolean add(T entity) throws DAOException;

	T update(T entity) throws DAOException;
}