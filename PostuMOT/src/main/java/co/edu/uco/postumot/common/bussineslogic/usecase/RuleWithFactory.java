package co.edu.uco.postumot.common.bussineslogic.usecase;

import co.edu.uco.postumot.common.data.dao.DAOFactory;

public interface RuleWithFactory <T>{
	void execute(T data, DAOFactory factory);
//	Unicamente detego reglas del porque van 

}
