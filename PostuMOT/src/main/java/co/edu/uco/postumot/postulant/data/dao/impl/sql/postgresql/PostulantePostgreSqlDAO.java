package co.edu.uco.postumot.postulant.data.dao.impl.sql.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.postumot.common.crosscutting.exception.DataPostuMOTException;
import co.edu.uco.postumot.common.data.dao.impl.sql.SqlDAO;
import co.edu.uco.postumot.postulant.data.dao.PostulanteDAO;
import co.edu.uco.postumot.postulant.entity.PostulanteEntity;

public final class PostulantePostgreSqlDAO extends SqlDAO implements PostulanteDAO{
	
	protected PostulantePostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(final PostulanteEntity data) {
		final StringBuilder statement = new StringBuilder();
		statement.append("INSERT INTO postulante(id, documento, primernombre, segundonombre, primerapellido"
				+ "segundoapellido,telefono,correo,genero,city_id,tipodocumento_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())) {

			preparedStatement.setObject(1, data.getId());
			preparedStatement.setInt(2, data.getDocumento());
			preparedStatement.setString(3, data.getFirstName());
			preparedStatement.setString(4, data.getSecondName());
			preparedStatement.setString(5, data.getLastName());
			preparedStatement.setString(6, data.getLastSecondName());
			preparedStatement.setLong(7, data.getPhone());
			preparedStatement.setString(8, data.getEmail());
			preparedStatement.setString(9, data.getEmail());
			preparedStatement.setString(10, data.getSex());
			preparedStatement.setObject(11, data.getCity().getId());
			preparedStatement.setObject(12, data.getTipoDocumento().getId());
			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de llevar a cabo el registro de la información del nuevo país. Por favor intente de nuevo y si el problema persiste reporte la novedad...";
			var technicalMessage = "Se ha presentado un problema al tratar de registrar la informaciòn del nuevo país en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			throw DataPostuMOTException.crear(userMessage, technicalMessage, exception);
		}
	}

	@Override
	public PostulanteEntity findByID(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostulanteEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostulanteEntity> findByFilter(PostulanteEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PostulanteEntity data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID data) {
		// TODO Auto-generated method stub
		
	}

}
