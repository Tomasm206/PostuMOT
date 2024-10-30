package co.edu.uco.postumot.postulant.entity;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.DomainEntity;

public class TipoDocumentoEntity extends DomainEntity{
	
	private String name;
	
	protected TipoDocumentoEntity() {
		super(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
