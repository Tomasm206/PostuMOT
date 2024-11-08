package co.edu.uco.postumot.common.bussineslogic.adapter;

import java.util.List;

public interface Adapter<D, T> {
	D adaptSource(T data);

	T adaptTarget(D data);
	
	List<T> adaptTarget(List<D> data);
}
