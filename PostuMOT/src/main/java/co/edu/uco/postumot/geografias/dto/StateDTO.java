package co.edu.uco.postumot.geografias.dto;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.domain.DomainDTO;

public class StateDTO extends DomainDTO {

	private String name;
	private CountryDTO country;

	public StateDTO() {
		super(UUIDHelper.getDefaultAsString());
		setName(TextHelper.EMPTY);
		setCountry(CountryDTO.create());
	}

	public static final StateDTO create() {
		return new StateDTO();

	}

	public String getName() {
		return name;
	}

	public StateDTO setName(final String name) {
		this.name = TextHelper.applyTrim(name);
		return this;

	}

	public StateDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}

	@Override
	public String getId() {
		return super.getId();
	}

	public CountryDTO getCountry() {
		return country;
	}

	public StateDTO setCountry(final CountryDTO country) {
		this.country = ObjectHelper.getDefault(country, CountryDTO.create());
		return this;
	}

}
