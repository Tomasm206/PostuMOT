package co.edu.uco.postumot.geografias.businesslogic.usecase.city;

import java.util.List;

import co.edu.uco.postumot.common.bussineslogic.usecase.UseWithReturn;
import co.edu.uco.postumot.geografias.domain.CityDomain;

public interface FindCity extends UseWithReturn<CityDomain, List<CityDomain>> {
	
}
