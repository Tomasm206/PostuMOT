package co.edu.uco.postumot.postulant.bussineslogic.adapter.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.bussineslogic.adapter.Adapter;
import co.edu.uco.postumot.geografias.domain.CountryDomain;
import co.edu.uco.postumot.geografias.dto.CountryDTO;
import co.edu.uco.postumot.postulant.domain.PostulanteDomain;
import co.edu.uco.postumot.postulant.domain.TipoDocumentoDomain;
import co.edu.uco.postumot.postulant.dto.PostulanteDTO;
import co.edu.uco.postumot.postulant.dto.TipoDocumentoDTO;

public class TipoDocumentoDTOAdapter implements Adapter<TipoDocumentoDomain, TipoDocumentoDTO> {

	private static final Adapter<TipoDocumentoDomain, TipoDocumentoDTO> instance = new TipoDocumentoDTOAdapter();

	private TipoDocumentoDTOAdapter() {

	}

	public static Adapter<TipoDocumentoDomain, TipoDocumentoDTO> getCountryDTOAdapter() {
		return instance;
	}

	@Override
	public TipoDocumentoDomain adaptSource(TipoDocumentoDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, CountryDTO.create());
		return TipoDocumentoDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName());
	}

	@Override
	public TipoDocumentoDTO adaptTarget(TipoDocumentoDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data,
				TipoDocumentoDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
		return TipoDocumentoDTO.create().setId("").setName(domainToAdapt.getName());
	}

	@Override
	public List<TipoDocumentoDTO> adaptTarget(List<TipoDocumentoDomain> data) {
		var results = new ArrayList<TipoDocumentoDTO>();

		for (TipoDocumentoDomain domain : data) {
			results.add(adaptTarget(domain));
		}

		return results;
	}
}