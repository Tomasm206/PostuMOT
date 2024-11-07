package co.edu.uco.postumot.postulant.dto;


import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.domain.DomainDTO;

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
	
}
