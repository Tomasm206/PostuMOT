package co.edu.uco.postumot.common.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class Domain {

	private UUID id;

	protected Domain(final UUID id) {
		setId(id);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

}