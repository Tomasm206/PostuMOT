package co.edu.uco.postumot.geografias.businesslogic.adapter.entity;

import java.util.List;

import co.edu.uco.postumot.geografias.businesslogic.adapter.Adapter;




public final class CityEntityAdapter implements Adapter<CityEntity, CityDomain> {

	private static final Adapter<CityEntity, CityDomain> instance = new CityEntityAdapter();
	
	private CityEntityAdapter() {
		
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

	public static CityEntityAdapter getCityEntityAdapter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityDomain> adaptTarget(List<CityEntity> data) {
		// TODO Auto-generated method stub
		return null;
	}
}
