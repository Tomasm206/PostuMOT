package co.edu.uco.postumot.postulant.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.domain.Domain;
import co.edu.uco.postumot.geografias.domain.CityDomain;

public class PostulanteDomain extends Domain {
	
	private int documento;
    private String firstName;
    private String secondName;
    private String lastName;
    private String lastSecondName;
    private int phone;
    private String email; 
    private String sex;
    private TipoDocumentoDomain tipoDocumento;
    private CityDomain city;

    protected PostulanteDomain(final UUID id, final int documento,final String firstName, final String secondName, final String lastName, final String lastSecondName,
            final int phone, final String email, final String sex, final TipoDocumentoDomain tipoDocumento, final CityDomain city) {
        super(id);
        setDocumento(documento);
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

    @Override
    public UUID getId() {
        return super.getId();
    }

    public static final PostulanteDomain create(final UUID id, final int documento,final String firstName, final String secondName, final String lastName,
    		final String lastSecondName, final int phone, final String email, final String sex, final TipoDocumentoDomain tipoDocumento,
            final CityDomain city) {
        return new PostulanteDomain(id, documento, firstName, secondName, lastName, lastSecondName, phone, email, sex, tipoDocumento, city);
    }

    static final PostulanteDomain create() {
        return new PostulanteDomain(
            UUIDHelper.getDefault(), 
            0,
            TextHelper.EMPTY,
            TextHelper.EMPTY,
            TextHelper.EMPTY,
            TextHelper.EMPTY,
            0,               
            TextHelper.EMPTY,
            TextHelper.EMPTY,
            TipoDocumentoDomain.create(), 
            CityDomain.create()
        );
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastSecondName() {
        return lastSecondName;
    }

    public void setLastSecondName(String lastSecondName) {
        this.lastSecondName = lastSecondName;
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
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

	public TipoDocumentoDomain getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoDomain tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public CityDomain getCity() {
		return city;
	}

	public void setCity(CityDomain city) {
		this.city = city;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(final int documento) {
		this.documento = documento;
	}
    
}
