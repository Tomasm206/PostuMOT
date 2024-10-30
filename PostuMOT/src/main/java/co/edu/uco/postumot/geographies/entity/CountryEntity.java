package co.edu.uco.postumot.geographies.entity;

import java.util.UUID;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.DomainEntity;

public class CountryEntity extends DomainEntity {

	private String name;

	public CountryEntity() {
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
	public void setId(final UUID id) {
		super.setId(id);

	}

	@Override
	public UUID getId() {
		return super.getId();
	}

}
