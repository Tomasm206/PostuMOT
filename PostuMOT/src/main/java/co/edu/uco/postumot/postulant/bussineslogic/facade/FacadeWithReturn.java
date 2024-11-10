package co.edu.uco.postumot.postulant.bussineslogic.facade;

public interface FacadeWithReturn <T,R> {
	R execute(T data);
	
}
