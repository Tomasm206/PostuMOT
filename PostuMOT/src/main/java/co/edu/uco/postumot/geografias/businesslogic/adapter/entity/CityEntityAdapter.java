package co.edu.uco.postumot.geografias.businesslogic.adapter.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.bussineslogic.adapter.Adapter;
import co.edu.uco.postumot.geografias.domain.CityDomain;
import co.edu.uco.postumot.geografias.domain.StateDomain;
import co.edu.uco.postumot.geografias.entity.CityEntity;
import co.edu.uco.postumot.geografias.entity.StateEntity;

public final class CityEntityAdapter implements Adapter<CityDomain, CityEntity> {

	private static final Adapter<CityDomain, CityEntity> instance = new CityEntityAdapter();

	private CityEntityAdapter() {

	}

	public static Adapter<CityDomain, CityEntity> getCityEntityAdapter() {
		return instance;
	}

	@Override
	public CityDomain adaptSource(CityEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new CityEntity());
		return CityDomain.create(entityToAdapt.getId(), entityToAdapt.getName(), StateDomain.create());
	}

	@Override
	public CityEntity adaptTarget(CityDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data,
				CityDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY, StateDomain.create()));

		var entityAdapted = new CityEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		entityAdapted.setState(new StateEntity());

		return entityAdapted;
	}

	@Override
	public List<CityEntity> adaptTarget(List<CityDomain> data) {
		var results = new ArrayList<CityEntity>();

		for (CityDomain domain : data) {
			results.add(adaptTarget(domain));
		}

		return results;
	}

}