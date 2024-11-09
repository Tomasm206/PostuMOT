package co.edu.uco.postumot.postulant.entity;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.domain.DomainEntity;
import co.edu.uco.postumot.geografias.entity.CityEntity;

public class PostulanteEntity extends DomainEntity {

	private int documento;
	private String firstName;
	private String secondName;
	private String lastName;
	private String lastSecondName;
	private int phone;
	private String email;
	private String sex;
	private TipoDocumentoEntity tipoDocumento;
	private CityEntity city;

	public PostulanteEntity() {
		super(UUIDHelper.getDefault());
		setDocumento(documento);
		setTipoDocumento(tipoDocumento);
		setFirstName(firstName);
		setSecondName(secondName);
		setLastName(lastName);
		setLastSecondName(lastSecondName);
		setPhone(phone);
		setEmail(email);
		setSex(sex);
		setTipoDocumento(tipoDocumento);
		setCity(city);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = TextHelper.applyTrim(firstName);
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(final String secondName) {
		this.secondName = TextHelper.applyTrim(secondName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = TextHelper.applyTrim(lastName);
	}

	public String getLastSecondName() {
		return lastSecondName;
	}

	public void setLastSecondName(final String lastSecondName) {
		this.lastSecondName = TextHelper.applyTrim(lastSecondName);
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(final int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(final String sex) {
		this.sex = TextHelper.applyTrim(sex);
	}

	public CityEntity getCity() {
		return city;
	}

	public PostulanteEntity setCity(final CityEntity city) {
		this.city = ObjectHelper.getDefault(city, new CityEntity());
		return this;
	}

	public TipoDocumentoEntity getTipoDocumento() {
		return tipoDocumento;
	}

	public PostulanteEntity setTipoDocumento(final TipoDocumentoEntity tipoDocumento) {
		this.tipoDocumento = ObjectHelper.getDefault(tipoDocumento, new TipoDocumentoEntity());
		return this;
	}

	@Override
	public UUID getId() {
		return super.getId();
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

}