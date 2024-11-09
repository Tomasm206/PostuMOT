package co.edu.uco.postumot.postulant.dto;


import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.domain.DomainDTO;
import co.edu.uco.postumot.geografias.domain.CountryDomain;

public class TipoDocumentoDTO extends DomainDTO{

	private String name;
	
	protected TipoDocumentoDTO() {
		super(UUIDHelper.getDefaultAsString());
	}
	
	public static final TipoDocumentoDTO create() {
		return new TipoDocumentoDTO();
	}

	public String getName() {
		return name;
	}

	public TipoDocumentoDTO setId(final String id) {
		return this.setId(id);
	}

	public TipoDocumentoDTO setName(final String name) {
		// TODO Auto-generated method stub
		return this.setName(name);
	}
	
}
