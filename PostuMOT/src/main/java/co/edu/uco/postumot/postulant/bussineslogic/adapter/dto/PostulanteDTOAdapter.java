package co.edu.uco.postumot.postulant.bussineslogic.adapter.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.bussineslogic.adapter.Adapter;
import co.edu.uco.postumot.geografias.domain.CityDomain;
import co.edu.uco.postumot.geografias.dto.CityDTO;
import co.edu.uco.postumot.postulant.domain.PostulanteDomain;
import co.edu.uco.postumot.postulant.domain.TipoDocumentoDomain;
import co.edu.uco.postumot.postulant.dto.PostulanteDTO;

public final class PostulanteDTOAdapter implements Adapter<PostulanteDomain, PostulanteDTO> {

	private static final Adapter<PostulanteDomain, PostulanteDTO> instance = new PostulanteDTOAdapter();

	private PostulanteDTOAdapter() {

	}

	public static Adapter<PostulanteDomain, PostulanteDTO> getCityDTOAdapter() {
		return instance;
	}

	@Override
	public PostulanteDomain adaptSource(final PostulanteDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, PostulanteDTO.create());
		return PostulanteDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getDocumento(),data.getFirstName(), data.getSecondName(), data.getLastName(),
				data.getLastSecondName(),data.getPhone(),data.getEmail(),data.getSex(), TipoDocumentoDomain.create(), CityDomain.create());
	}
	
	@Override
	public PostulanteDTO adaptTarget(final PostulanteDomain data) {
//		var domainToAdapt = ObjectHelper.getDefault(data, PostulanteDomain.create(UUIDHelper.getDefault(),0, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY,
//				0, TextHelper.EMPTY,TextHelper.EMPTY,null,null));
//		return PostulanteDTO.create().setId("").setDocumento(domainToAdapt.getDocumento()).setFirstName(domainToAdapt.getFirstName());
		return null;
	}

	@Override
	public List<PostulanteDTO> adaptTarget(final List<PostulanteDomain> data) {
		var results = new ArrayList<PostulanteDTO>();
		
		for (PostulanteDomain domain : data) {
			results.add(adaptTarget(domain));
		}
			
		return results;
	}
//	Basicamente convierte de domain a dto y viceversa
//	en el ultimo comvertimos lista de dto to domain

}