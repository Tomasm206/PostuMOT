package co.edu.uco.postumot.geographies.entity;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.DomainEntity;

public class CityEntity extends DomainEntity {

	private String name;
	private StateEntity state;

	public CityEntity() {
		super(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
		setState(new StateEntity());
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

	public StateEntity getState() {
		return state;
	}

	public void setState(final StateEntity state) {
		this.state = ObjectHelper.getDefault(state, new StateEntity());
	}

}
