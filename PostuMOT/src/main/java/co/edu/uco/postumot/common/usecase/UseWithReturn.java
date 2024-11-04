package co.edu.uco.postumot.common.usecase;

public interface UseWithReturn <D, R> {
	R execute(D data);
}
