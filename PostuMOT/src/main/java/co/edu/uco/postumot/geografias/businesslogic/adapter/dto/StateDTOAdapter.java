package co.edu.uco.postumot.geografias.businesslogic.adapter.dto;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.businesslogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.CountryDomain;
import co.edu.uco.ucobet.domain.StateDomain;
import co.edu.uco.ucobet.dto.CountryDTO;
import co.edu.uco.ucobet.dto.StateDTO;

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
		return StateDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName());
	}

	@Override
	public StateDTO adaptTarget(final StateDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data,
				StateDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
		return StateDTO.create().setId("").setName(domainToAdapt.getName());
	}
//	Basicamente convierte de domain a dto y viceversa
}
