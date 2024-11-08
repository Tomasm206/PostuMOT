package co.edu.uco.postumot.geografias.data.dao.impl.sql.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.postumot.common.crosscutting.exception.DataPostuMOTException;
import co.edu.uco.postumot.common.data.dao.impl.sql.SqlDAO;
import co.edu.uco.postumot.geografias.data.dao.CityDAO;
import co.edu.uco.postumot.geografias.entity.CityEntity;



public final class CityPostgreSqlDAO extends SqlDAO implements CityDAO {

	protected CityPostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(final CityEntity data) {

		final StringBuilder statement = new StringBuilder();
		statement.append("INSERT INTO City(id, name, state) VALUES (?, ?, ?)");

		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())) {

			preparedStatement.setObject(1, data.getId());
			preparedStatement.setString(2, data.getName());
			preparedStatement.setObject(3, data.getState().getId());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de llevar a cabo el registro de la información del nuevo país. Por favor intente de nuevo y si el problema persiste reporte la novedad...";
			var technicalMessage = "Se ha presentado un problema al tratar de registrar la informaciòn del nuevo país en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			throw DataPostuMOTException.crear(userMessage, technicalMessage, exception);
		}

	}

	@Override
	public CityEntity findByID(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityEntity> findByFilter(CityEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CityEntity data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(UUID data) {
		// TODO Auto-generated method stub

	}
}
