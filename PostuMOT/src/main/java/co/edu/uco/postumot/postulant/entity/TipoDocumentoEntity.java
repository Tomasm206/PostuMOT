package co.edu.uco.postumot.postulant.entity;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.domain.DomainEntity;

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
		this.name = TextHelper.applyTrim(name);
	}

	@Override
	protected UUID getId() {
		return super.getId();
	}

	@Override
	protected void setId(final UUID id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}
}
