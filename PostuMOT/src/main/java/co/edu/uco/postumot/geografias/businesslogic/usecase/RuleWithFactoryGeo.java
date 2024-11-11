package co.edu.uco.postumot.geografias.businesslogic.usecase;

import co.edu.uco.postumot.geografias.data.dao.DAOFactoryGeografias;

public interface RuleWithFactoryGeo <T>{
	void execute(T data, DAOFactoryGeografias factory);
//	Unicamente detego reglas del porque van 

}
