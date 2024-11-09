package co.edu.uco.postumot.postulant.bussineslogic.adapter.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.bussineslogic.adapter.Adapter;
import co.edu.uco.postumot.postulant.domain.PostulanteDomain;
import co.edu.uco.postumot.postulant.domain.TipoDocumentoDomain;
import co.edu.uco.postumot.postulant.entity.PostulanteEntity;
import co.edu.uco.postumot.postulant.entity.TipoDocumentoEntity;

public final class TipoDocumentoEntityAdapter implements Adapter<TipoDocumentoDomain, TipoDocumentoEntity > {

	private static final Adapter<TipoDocumentoDomain,TipoDocumentoEntity> instance = new TipoDocumentoEntityAdapter();

	private TipoDocumentoEntityAdapter() {

	}

	public static Adapter<TipoDocumentoDomain, TipoDocumentoEntity> getCityEntityAdapter() {
		return instance;
	}

	@Override
	public TipoDocumentoDomain adaptSource(final TipoDocumentoEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new TipoDocumentoEntity());
		return TipoDocumentoDomain.create(entityToAdapt.getId(),entityToAdapt.getName());
	}

	@Override
	public TipoDocumentoEntity adaptTarget(final TipoDocumentoDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, TipoDocumentoDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY)); 
		var entityAdapted = new TipoDocumentoEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		return entityAdapted;
	}

	@Override
	public List<TipoDocumentoEntity> adaptTarget(List<TipoDocumentoDomain> data) {
		var results = new ArrayList<TipoDocumentoEntity>();

		for (TipoDocumentoDomain domain : data) {
			results.add(adaptTarget(domain));
		}

		return results;
	}
}