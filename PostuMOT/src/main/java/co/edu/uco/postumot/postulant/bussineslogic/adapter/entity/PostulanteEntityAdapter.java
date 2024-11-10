package co.edu.uco.postumot.postulant.bussineslogic.adapter.entity;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.bussineslogic.adapter.Adapter;
import co.edu.uco.postumot.geografias.domain.CityDomain;
import co.edu.uco.postumot.geografias.entity.CityEntity;
import co.edu.uco.postumot.postulant.domain.PostulanteDomain;
import co.edu.uco.postumot.postulant.domain.TipoDocumentoDomain;
import co.edu.uco.postumot.postulant.dto.TipoDocumentoDTO;
import co.edu.uco.postumot.postulant.entity.PostulanteEntity;
import co.edu.uco.postumot.postulant.entity.TipoDocumentoEntity;

public class PostulanteEntityAdapter implements Adapter<PostulanteDomain, PostulanteEntity> {

	private static final Adapter<PostulanteDomain, PostulanteEntity> instance = new PostulanteEntityAdapter();

	private PostulanteEntityAdapter() {

	}

	public static Adapter<PostulanteDomain, PostulanteEntity> getPostulanteEntityAdapter() {
		return instance;
	}

	@Override
	public PostulanteDomain adaptSource(final PostulanteEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new PostulanteEntity());
		return PostulanteDomain.create(entityToAdapt.getId(), entityToAdapt.getDocumento(), entityToAdapt.getFirstName(),
				entityToAdapt.getSecondName(), entityToAdapt.getLastName(), entityToAdapt.getLastSecondName(), entityToAdapt.getPhone(),
				entityToAdapt.getEmail(), entityToAdapt.getSex(), TipoDocumentoDomain.create(), CityDomain.create());
	}

	@Override
	public PostulanteEntity adaptTarget(final PostulanteDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, PostulanteDomain.create(UUIDHelper.getDefault(), 0,
				TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, 0, TextHelper.EMPTY,
				TextHelper.EMPTY, TipoDocumentoDomain.create(), CityDomain.create()));

		var entityAdapted = new PostulanteEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setDocumento(domainToAdapt.getDocumento());
		entityAdapted.setFirstName(domainToAdapt.getFirstName());
		entityAdapted.setSecondName(domainToAdapt.getSecondName());
		entityAdapted.setLastName(domainToAdapt.getLastName());
		entityAdapted.setLastSecondName(domainToAdapt.getLastSecondName());
		entityAdapted.setPhone(domainToAdapt.getPhone());
		entityAdapted.setEmail(domainToAdapt.getEmail());
		entityAdapted.setSex(domainToAdapt.getSex());
		entityAdapted.setTipoDocumento(new TipoDocumentoEntity());
		entityAdapted.setCity(new CityEntity());

		return new PostulanteEntity();
	}

	@Override
	public List<PostulanteEntity> adaptTarget(List<PostulanteDomain> data) {
		var results = new ArrayList<PostulanteEntity>();

		for (PostulanteDomain domain : data) {
			results.add(adaptTarget(domain));
		}

		return results;
	}

}
