package co.edu.uco.postumot.geografias.data.dao;

import java.util.List;

public interface RetrieveDAO<T, I> {

	T findByID(I id);

	List<T> findAll();

	List<T> findByFilter(T filter);

}