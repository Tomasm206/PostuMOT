package co.edu.uco.postumot.geografias.businesslogic.adapter.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.bussineslogic.adapter.Adapter;
import co.edu.uco.postumot.geografias.domain.CountryDomain;
import co.edu.uco.postumot.geografias.domain.StateDomain;
import co.edu.uco.postumot.geografias.entity.CountryEntity;
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
		var entityToAdapt = ObjectHelper.getDefault(data, new StateEntity());
		return StateDomain.create(entityToAdapt.getId(), entityToAdapt.getName(), CountryDomain.create());
	}

	@Override
	public StateEntity adaptTarget(StateDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, StateDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY,CountryDomain.create()));
		
		var entityAdapted = new StateEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		entityAdapted.setCountry(new CountryEntity());
		
		return entityAdapted;
	}

	@Override
	public List<StateEntity> adaptTarget(List<StateDomain> data) {
		var results = new ArrayList<StateEntity>();

		for (StateDomain domain : data) {
			results.add(adaptTarget(domain));
		}

		return results;
	}
}