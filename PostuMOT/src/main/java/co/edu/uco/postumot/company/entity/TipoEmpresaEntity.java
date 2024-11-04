package co.edu.uco.postumot.company.entity;

import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.domain.DomainEntity;

public class TipoEmpresaEntity extends DomainEntity{
	
	private String nombre;
	
	
	protected TipoEmpresaEntity() {
		super(UUIDHelper.getDefault());
		setNombre(nombre);
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

}
