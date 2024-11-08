package co.edu.uco.postumot.geografias.businesslogic.adapter.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.postumot.common.bussineslogic.adapter.Adapter;
import co.edu.uco.postumot.geografias.domain.CityDomain;
import co.edu.uco.postumot.geografias.dto.CityDTO;

public final class CityDTOAdapter implements Adapter<CityDomain, CityDTO> {

	private static final Adapter<CityDomain, CityDTO> instance = new CityDTOAdapter();

	private CityDTOAdapter() {

	}

	public static Adapter<CityDomain, CityDTO> getCityDTOAdapter() {
		return instance;
	}

	@Override
	public CityDomain adaptSource(final CityDTO data) {
//		var dtoToAdapt = ObjectHelper.getDefault(data, CityDTO.create());
//		return CityDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName());
		return null;
	}

	@Override
	public CityDTO adaptTarget(final CityDomain data) {
//		var domainToAdapt = ObjectHelper.getDefault(data, CityDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
//		return CityDTO.create().setId("").setName(domainToAdapt.getName());
		return null;
	}

	@Override
	public List<CityDTO> adaptTarget(final List<CityDomain> data) {
		var results = new ArrayList<CityDTO>();
		
		for (CityDomain domain : data) {
			results.add(adaptTarget(domain));
		}
			
		return results;
	}
//	Basicamente convierte de domain a dto y viceversa
//	en el ultimo comvertimos lista de dto to domain
}