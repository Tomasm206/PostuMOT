package co.edu.uco.postumot.common.bussineslogic.usecase;

public interface UseWithReturn <D, R> {
	R execute(D data);
}
