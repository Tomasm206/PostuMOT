package co.edu.uco.postumot.common.domain;

import java.util.UUID;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class DomainEntity {

	private UUID id;

	protected DomainEntity(final UUID id) {
		setId(id);
	}

	protected UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

}
