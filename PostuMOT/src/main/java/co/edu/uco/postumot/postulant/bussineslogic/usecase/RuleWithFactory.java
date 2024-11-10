package co.edu.uco.postumot.postulant.bussineslogic.usecase;

import co.edu.uco.postumot.postulant.data.dao.DAOFactoryPostulante;

public interface RuleWithFactory <T>{
	void execute(T data, DAOFactoryPostulante factory);
//	Unicamente detego reglas del porque van 

}
