package co.edu.uco.postumot.geografias.businesslogic.usecase.city.impl;

import java.util.List;

import co.edu.uco.postumot.geografias.businesslogic.usecase.city.FindCity;
import co.edu.uco.postumot.geografias.data.dao.DAOFactoryGeografias;
import co.edu.uco.postumot.geografias.domain.CityDomain;

public final class FindCityImpl implements FindCity{
	
	public FindCityImpl (final DAOFactoryGeografias daoFactory) {
//		unicamente para que me deje pasar
	}
	
	@Override
	public List<CityDomain> execute(final CityDomain data) {
		// TODO Auto-generated method stub
		return null;
	}

}
