package co.edu.uco.postumot.geografias.businesslogic.adapter.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.bussineslogic.adapter.Adapter;
import co.edu.uco.postumot.geografias.domain.CountryDomain;
import co.edu.uco.postumot.geografias.domain.StateDomain;
import co.edu.uco.postumot.geografias.dto.CountryDTO;
import co.edu.uco.postumot.geografias.dto.StateDTO;

public class CountryDTOAdapter implements Adapter<CountryDomain, CountryDTO> {

	private static final Adapter<CountryDomain, CountryDTO> instance = new CountryDTOAdapter();

	private CountryDTOAdapter() {

	}

	public static Adapter<CountryDomain, CountryDTO> getCountryDTOAdapter() {
		return instance;
	}

	@Override
	public CountryDomain adaptSource(final CountryDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, CountryDTO.create());
		return CountryDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName());
	}

	@Override
	public CountryDTO adaptTarget(final CountryDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data,
				CountryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
		return CountryDTO.create().setId("").setName(domainToAdapt.getName());
	}
//	Basicamente convierte de domain a dto y viceversa

	@Override
	public List<CountryDTO> adaptTarget(List<CountryDomain> data) {
		var results = new ArrayList<CountryDTO>();
		for (CountryDomain domain : data) {
			results.add(adaptTarget(domain));
		}

		return results;
	}
}