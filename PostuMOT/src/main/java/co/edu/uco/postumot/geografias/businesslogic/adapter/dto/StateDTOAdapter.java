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

public class StateDTOAdapter implements Adapter<StateDomain, StateDTO> {

	private static final Adapter<StateDomain, StateDTO> instance = new StateDTOAdapter();

	private StateDTOAdapter() {

	}

	public static Adapter<StateDomain, StateDTO> getStateDTOAdapter() {
		return instance;
	}

	@Override
	public StateDomain adaptSource(final StateDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, StateDTO.create());
		return StateDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName(),CountryDomain.create());
	}

	@Override
	public StateDTO adaptTarget(final StateDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data,
				StateDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY, CountryDomain.create()));
		return StateDTO.create().setId("").setName(domainToAdapt.getName()).setCountry(CountryDTO.create());
	}
	
//	Basicamente convierte de domain a dto y viceversa

	@Override
	public List<StateDTO> adaptTarget(List<StateDomain> data) {
		var results = new ArrayList<StateDTO>();
		for (StateDomain domain : data) {
			results.add(adaptTarget(domain));
		}

		return results;
	}
}
