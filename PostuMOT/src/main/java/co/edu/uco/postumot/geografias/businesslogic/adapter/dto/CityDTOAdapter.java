package co.edu.uco.postumot.geografias.businesslogic.adapter.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.bussineslogic.adapter.Adapter;
import co.edu.uco.postumot.geografias.domain.CityDomain;
import co.edu.uco.postumot.geografias.domain.StateDomain;
import co.edu.uco.postumot.geografias.dto.CityDTO;
import co.edu.uco.postumot.geografias.dto.StateDTO;

public final class CityDTOAdapter implements Adapter<CityDomain, CityDTO> {

	private static final Adapter<CityDomain, CityDTO> instance = new CityDTOAdapter();

	private CityDTOAdapter() {

	}

	public static Adapter<CityDomain, CityDTO> getCityDTOAdapter() {
		return instance;
	}

	@Override
	public CityDomain adaptSource(final CityDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, CityDTO.create());
		return CityDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName(), StateDomain.create());

	}

	@Override
	public CityDTO adaptTarget(final CityDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, CityDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY, StateDomain.create()));
		return CityDTO.create().setId("").setName(domainToAdapt.getName()).setState(StateDTO.create());
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