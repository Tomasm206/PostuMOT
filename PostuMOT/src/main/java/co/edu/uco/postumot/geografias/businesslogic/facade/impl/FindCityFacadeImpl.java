package co.edu.uco.postumot.geografias.businesslogic.facade.impl;

import java.util.List;

import co.edu.uco.postumot.common.crosscutting.exception.BusinessLogicPostuMOTException;
import co.edu.uco.postumot.common.crosscutting.exception.PostuMOTException;
import co.edu.uco.postumot.common.data.dao.enums.DAOSource;
import co.edu.uco.postumot.geografias.businesslogic.adapter.dto.CityDTOAdapter;
import co.edu.uco.postumot.geografias.businesslogic.facade.FindCityFacade;
import co.edu.uco.postumot.geografias.businesslogic.usecase.city.impl.FindCityImpl;
import co.edu.uco.postumot.geografias.data.dao.DAOFactoryGeografias;
import co.edu.uco.postumot.geografias.dto.CityDTO;

public final class FindCityFacadeImpl implements FindCityFacade{

	@Override
	public List<CityDTO> execute(CityDTO data) {
		var factory = DAOFactoryGeografias.getFactory(DAOSource.SQLSERVER);

		try {
//			transaccion good
			
			
//			Lo que entra a la capa de negocio son los DTOS
			var findCityUseCase = new FindCityImpl(factory);
			var cityDomain = CityDTOAdapter.getCityDTOAdapter().adaptSource(data);
			
			return CityDTOAdapter.getCityDTOAdapter().adaptTarget(findCityUseCase.execute(cityDomain));
			

		} catch (final PostuMOTException exception) {
//			Falla la transaccion
			throw exception;
		}  catch (final Exception exception) { 
			var usserMessage = "Se ha presentado un problema tratando de consultar la informacion de una nueva ciudad";
			var technicalMessage = "Se ha presentado un problema inesperado consultando la informacion de la nueva ciudad. Por favor revise el log para tener más detalles...";
			
			throw BusinessLogicPostuMOTException.crear(usserMessage, technicalMessage);
		}finally {
			factory.closeConnection();
		}
	}

}
