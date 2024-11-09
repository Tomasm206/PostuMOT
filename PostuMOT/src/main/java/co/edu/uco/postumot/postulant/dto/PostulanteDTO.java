package co.edu.uco.postumot.postulant.dto;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.domain.DomainDTO;
import co.edu.uco.postumot.geografias.domain.CityDomain;
import co.edu.uco.postumot.geografias.dto.CityDTO;

public class PostulanteDTO extends DomainDTO{
	
	private int documento;
	private String firstName;
    private String secondName;
    private String lastName;
    private String lastSecondName;
    private int phone;
    private String email; // Email definido como String
    private String sex;
	private TipoDocumentoDTO tipoDocumento;
	private CityDTO ciudad;
	
	protected PostulanteDTO() {
		super(UUIDHelper.getDefaultAsString());
		setDocumento(documento);
		setFirstName(firstName);
		setSecondName(secondName);
		setLastName(lastName);
		setLastSecondName(lastSecondName);
		setPhone(phone);
		setEmail(email);
		setSex(sex);
		setTipoDocumento(tipoDocumento);
		setCiudad(ciudad);
	}
	
	public static final PostulanteDTO create() {
		return new PostulanteDTO();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = TextHelper.applyTrim(firstName);
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.firstName = TextHelper.applyTrim(secondName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.firstName = TextHelper.applyTrim(lastName);
	}

	public String getLastSecondName() {
		return lastSecondName;
	}

	public void setLastSecondName(String lastSecondName) {
		this.lastSecondName = TextHelper.applyTrim(lastSecondName);
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = TextHelper.applyTrim(email);
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = TextHelper.applyTrim(sex);
	}

	public TipoDocumentoDTO getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(final TipoDocumentoDTO tipoDocumento) {
		this.tipoDocumento = ObjectHelper.getDefault(tipoDocumento, TipoDocumentoDTO.create());
	}

	public CityDTO getCiudad() {
		return ciudad;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public void setCiudad(final CityDTO ciudad) {
		this.ciudad = ObjectHelper.getDefault(ciudad, CityDTO.create());
	}

//	public PostulanteDTO setId(final String id) {
//		// TODO Auto-generated method stub
//		return this.setId(id);
//	}
	
}
