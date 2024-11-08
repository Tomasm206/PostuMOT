package co.edu.uco.postumot.geografias.businesslogic.adapter.dto;

import java.util.List;

import co.edu.uco.postumot.common.bussineslogic.adapter.Adapter;
import co.edu.uco.postumot.geografias.domain.StateDomain;
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
//		var dtoToAdapt = ObjectHelper.getDefault(data, StateDTO.create());
//		return StateDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName());
		return null;
	}

	@Override
	public StateDTO adaptTarget(final StateDomain data) {
//		var domainToAdapt = ObjectHelper.getDefault(data,
//				StateDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
//		return StateDTO.create().setId("").setName(domainToAdapt.getName());
		return null;
	}
//	Basicamente convierte de domain a dto y viceversa

	@Override
	public List<StateDTO> adaptTarget(List<StateDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}
}
