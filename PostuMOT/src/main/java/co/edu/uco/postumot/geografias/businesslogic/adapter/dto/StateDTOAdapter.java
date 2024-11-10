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
import co.edu.uco.postumot.postulant.domain.TipoDocumentoDomain;

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
		return StateDTO.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName(), CountryDomain.create());
	}

	@Override
	public StateDTO adaptTarget(final StateDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data,
				StateDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY, StateDomain.create()));
		return StateDTO.create().setName(domainToAdapt.getName());
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
