package co.edu.uco.postumot.geografias.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.domain.Domain;

public class CityDomain extends Domain {

	private String name;
	private StateDomain state;

	private CityDomain(final UUID id, final String name) {
		super(id);
		setName(name);
		setState(state);
	}

	public static final CityDomain create(final UUID id, final String name) {
		return new CityDomain(id, name);
	}

	public static final CityDomain create() {
		return new CityDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
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

	public StateDomain getState() {
		return state;
	}

	private void setState(final StateDomain country) {
		this.state = ObjectHelper.getDefault(country, StateDomain.create());
	}

}
