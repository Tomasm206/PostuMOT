package co.edu.uco.postumot.geografias.dto;

import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.domain.DomainDTO;

public class CountryDTO extends DomainDTO {

	private String name;

	public CountryDTO() {
		super(UUIDHelper.getDefaultAsString());
	}

	public static final CountryDTO create() {
		return new CountryDTO();
	}

	public String getName() {
		return name;
	}

	public CountryDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}

	@Override
	public String getId() {
		return super.getId();
	}

}
