package co.edu.uco.postumot.geografias.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.domain.Domain;
import co.edu.uco.postumot.geografias.domain.CountryDomain;

public class StateDomain extends Domain {

	private String name;
	private CountryDomain country;
	
	private StateDomain (final UUID id, final String name, final CountryDomain country) {
		super(id);
		setName(name);
		setCountry(country);
	}	
	
	public static final StateDomain create (final UUID id, final String name, final CountryDomain country) {
		return new StateDomain(id, name, country);
	}
	
	public static final StateDomain create () {
		return new StateDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, CountryDomain.create());
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

	protected CountryDomain getCountry() {
		return country;
	}

	private void setCountry(final CountryDomain country) {
		this.country = ObjectHelper.getDefault(country, CountryDomain.create());
	}
	
	
	
}

