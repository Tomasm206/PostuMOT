package co.edu.uco.postumot.company.entity;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.DomainEntity;

public class EmpresaEntity extends DomainEntity {
	
	private long nit;
	private String nombre;
	private long telefono;
	private TipoEmpresaEntity tipoEmpresa;
	
	protected EmpresaEntity() {
		super(UUIDHelper.getDefault());
		setNit(nit);
		setNombre(nombre);
		setTelefono(telefono);
		setTipoEmpresa(tipoEmpresa);
	}

	public long getNit() {
		return nit;
	}
	
//	evaluar el parametro de poner nit por normas de negocio
	public void setNit(long nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}
//	evaluar el parametro de poner nombre por normas de negocio
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public TipoEmpresaEntity getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(TipoEmpresaEntity tipoEmpresa) {
		this.tipoEmpresa = ObjectHelper.getDefault(tipoEmpresa, new TipoEmpresaEntity());
	}
}
