package co.edu.uco.postumot.geografias.businesslogic.usecase;

public interface UseWithReturn <D, R> {
	R execute(D data);
}
