package co.edu.uco.postumot.postulant.dto;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.domain.DomainDTO;
import co.edu.uco.postumot.geografias.dto.CityDTO;

public class PostulanteDTO extends DomainDTO {
	
	private int documento;
	private String firstName;
    private String secondName;
    private String lastName;
    private String lastSecondName;
    private long phone;
    private String email; 
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

	public PostulanteDTO setFirstName(String firstName) {
		this.firstName = TextHelper.applyTrim(firstName);
		return this;
	}

	public String getSecondName() {
		return secondName;
	}

	public PostulanteDTO setSecondName(String secondName) {
		this.secondName = TextHelper.applyTrim(secondName);
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public PostulanteDTO setLastName(String lastName) {
		this.lastName = TextHelper.applyTrim(lastName);
		return this;
	}

	public String getLastSecondName() {
		return lastSecondName;
	}

	public PostulanteDTO setLastSecondName(String lastSecondName) {
		this.lastSecondName = TextHelper.applyTrim(lastSecondName);
		return this;
	}

	public long getPhone() {
		return phone;
	}

	public PostulanteDTO setPhone(long phone) {
		this.phone = phone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public PostulanteDTO setEmail(String email) {
		this.email = TextHelper.applyTrim(email);
		return this;
	}

	public String getSex() {
		return sex;
	}

	public PostulanteDTO setSex(String sex) {
		this.sex = TextHelper.applyTrim(sex);
		return this;
	}

	public TipoDocumentoDTO getTipoDocumento() {
		return tipoDocumento;
	}
	
	public PostulanteDTO setTipoDocumento(final TipoDocumentoDTO tipoDocumento) {
		this.tipoDocumento = ObjectHelper.getDefault(tipoDocumento, TipoDocumentoDTO.create());
		return this;
	}

	public CityDTO getCiudad() {
		return ciudad;
	}

	public int getDocumento() {
		return documento;
	}

	public PostulanteDTO setDocumento(int documento) {
		this.documento = documento;
		return this;
	}

	public PostulanteDTO setCiudad(final CityDTO ciudad) {
		this.ciudad = ObjectHelper.getDefault(ciudad, CityDTO.create());
		return this;
	}
}

