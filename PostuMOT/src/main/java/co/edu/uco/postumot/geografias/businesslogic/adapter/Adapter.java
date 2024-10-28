package co.edu.uco.postumot.geografias.businesslogic.adapter;

public interface Adapter<D, T> {
	D adaptSource(T data);

	T adaptTarget(D data);
}
