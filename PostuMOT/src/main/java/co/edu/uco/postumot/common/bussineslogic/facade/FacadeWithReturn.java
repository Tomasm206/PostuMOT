package co.edu.uco.postumot.common.bussineslogic.facade;

public interface FacadeWithReturn <T,R> {
	R execute(T data);
	
}
