package co.edu.uco.postumot.geografias.businesslogic.adapter.entity;

import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.bussineslogic.adapter.Adapter;
import co.edu.uco.postumot.geografias.domain.CountryDomain;
import co.edu.uco.postumot.geografias.entity.CountryEntity;

public class CountryEntityAdapter implements Adapter<CountryDomain, CountryEntity> {

	private static final Adapter<CountryDomain, CountryEntity> instance = new CountryEntityAdapter();

	private CountryEntityAdapter() {

	}

	public static Adapter<CountryDomain, CountryEntity> getCountryEntityAdapter() {
		return instance;
	}

	@Override
	public CountryDomain adaptSource(final CountryEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new CountryEntity());
		return CountryDomain.create(entityToAdapt.getId(), entityToAdapt.getName());

	}

	@Override
	public CountryEntity adaptTarget(final CountryDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data,
				CountryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));

		var entityAdapted = new CountryEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());

		return new CountryEntity();
	}

	@Override
	public List<CountryEntity> adaptTarget(List<CountryDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}

}
