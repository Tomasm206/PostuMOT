package co.edu.uco.postumot.geographies.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.domain.Domain;

public class CountryDomain extends Domain {

	private String name;

	private CountryDomain(final UUID id, final String name) {
		super(id);
		setName(name);
	}

	public static final CountryDomain create(final UUID id, final String name) {
		return new CountryDomain(id, name);
	}

//	Sin modificador de acceso, mismo paquete
	static final CountryDomain create() {
		return new CountryDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
	}

	public String getName() {
		return name;
	}

	private void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}

	@Override
	public UUID getId() {
		return super.getId();
	}
}