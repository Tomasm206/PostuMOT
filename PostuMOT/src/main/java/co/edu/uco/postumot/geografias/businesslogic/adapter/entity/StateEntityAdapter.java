package co.edu.uco.postumot.geografias.businesslogic.adapter.entity;

import java.util.List;

import co.edu.uco.postumot.common.bussineslogic.adapter.Adapter;
import co.edu.uco.postumot.geografias.domain.StateDomain;
import co.edu.uco.postumot.geografias.entity.StateEntity;

public class StateEntityAdapter implements Adapter<StateDomain, StateEntity> {

	private static final Adapter<StateDomain, StateEntity> instance = new StateEntityAdapter();

	private StateEntityAdapter() {

	}

	public static Adapter<StateDomain, StateEntity> getStateEntityAdapter() {
		return instance;
	}

	@Override
	public StateDomain adaptSource(StateEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateEntity adaptTarget(StateDomain data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateEntity> adaptTarget(List<StateDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}
}