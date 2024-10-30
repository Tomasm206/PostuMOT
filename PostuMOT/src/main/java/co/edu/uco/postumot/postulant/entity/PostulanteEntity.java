package co.edu.uco.postumot.postulant.entity;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.DomainEntity;
import co.edu.uco.postumot.geographies.entity.CityEntity;

public class PostulanteEntity extends DomainEntity {
	
	 private String firstName;
	 private String secondName;
	 private String lastName;
	 private String lastSecondName;
	 private long phone;
	 private char email;
	 private String sex;
	 private TipoDocumentoEntity tipoDocumento;
	 private CityEntity city;
	
	protected PostulanteEntity() {
		super(UUIDHelper.getDefault());
		setTipoDocumento(tipoDocumento);
		setFirstName(firstName);
		setSecondName(secondName);
		setLastName(lastName);
		setLastSecondName(lastSecondName);
		setPhone(phone);
		setEmail(email);
		setSex(sex);
		setTipoDocumento(tipoDocumento);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(final String secondName) {
		this.secondName = secondName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
	public String getLastSecondName() {
		return lastSecondName;
	}
	public void setLastSecondName(final String lastSecondName) {
		this.lastSecondName = lastSecondName;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(final long phone) {
		this.phone = phone;
	}
	public char getEmail() {
		return email;
	}
	public void setEmail(final char email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(final String sex) {
		this.sex = sex;
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(final CityEntity city) {
		this.city = ObjectHelper.getDefault(city, new CityEntity());
	}
	public TipoDocumentoEntity getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(final TipoDocumentoEntity tipoDocumento) {
		this.tipoDocumento = ObjectHelper.getDefault(tipoDocumento, new TipoDocumentoEntity());
	}
}