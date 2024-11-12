package co.edu.uco.postumot.postulant.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.domain.Domain;

public class TipoDocumentoDomain extends Domain{
	
	private String name;
	
	protected TipoDocumentoDomain(final UUID id, final String name) {
		super(id);
		setName(name);
	}
	
	public static final TipoDocumentoDomain create(final UUID id, final String name) {
		return new TipoDocumentoDomain(id, name);
	}
	
	static final TipoDocumentoDomain create() {
		return new TipoDocumentoDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public UUID getId() {
		return super.getId();
	}
	
	
}
