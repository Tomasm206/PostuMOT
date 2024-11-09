package co.edu.uco.postumot.common.domain;

import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;

public class DomainDTO {

	private String id;

	protected DomainDTO(final String id) {
		setIdentifier(id);
	}

	public String getId() {
		return id;
	}

	protected void setIdentifier(final String id) {
		this.id = TextHelper.getDefault(id, UUIDHelper.getDefaultAsString());
	}

}
