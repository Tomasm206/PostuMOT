package co.edu.uco.postumot.postulant.bussineslogic.adapter.entity;

import java.util.List;

import co.edu.uco.postumot.common.bussineslogic.adapter.Adapter;
import co.edu.uco.postumot.geografias.domain.CityDomain;
import co.edu.uco.postumot.geografias.entity.CityEntity;

public final class CityEntityAdapter implements Adapter<CityEntity, CityDomain> {

	private static final Adapter<CityEntity, CityDomain> instance = new CityEntityAdapter();

	private CityEntityAdapter() {

	}

	public static Adapter<CityEntity, CityDomain> getCityEntityAdapter() {
		return instance;
	}

	@Override
	public CityEntity adaptSource(CityDomain data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityDomain adaptTarget(CityEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityDomain> adaptTarget(List<CityEntity> data) {
		// TODO Auto-generated method stub
		return null;
	}



}