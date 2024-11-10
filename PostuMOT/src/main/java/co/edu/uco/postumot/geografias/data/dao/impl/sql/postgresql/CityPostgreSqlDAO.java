package co.edu.uco.postumot.geografias.data.dao.impl.sql.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.crosscutting.exception.DataPostuMOTException;
import co.edu.uco.postumot.common.data.dao.impl.sql.SqlDAO;
import co.edu.uco.postumot.geografias.data.dao.CityDAO;
import co.edu.uco.postumot.geografias.entity.CityEntity;



public final class CityPostgreSqlDAO extends SqlDAO implements CityDAO {

	public CityPostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public CityEntity findByID(UUID id) {
		var cityEntityFilter = new CityEntity();
		cityEntityFilter.setId(id);

		var result = findByFilter(cityEntityFilter);

		return (result.isEmpty()) ? new CityEntity() : result.get(0);
	}

	@Override
	public List<CityEntity> findAll() {
		return findByFilter(new CityEntity());
	}

	@Override
	public List<CityEntity> findByFilter(CityEntity filter) {
		final var statement = new StringBuilder();
		final var parameters = new ArrayList<>();
		final var resulSelect = new ArrayList<CityEntity>(); // Valor de los resultados almacenados
		var statementWasPrepared = false;
		final var resultWasExecuted = false;

		createSelect(statement);
		createFrom(statement);
		createWhere(statement, filter, parameters);
		createOrderBy(statement);

		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())) {
			for (int arrayIndex = 0; arrayIndex < parameters.size(); arrayIndex++) {
				var statementIndex = arrayIndex;
				preparedStatement.setObject(statementIndex, parameters.get(arrayIndex));

			}

			statementWasPrepared = true;

			ResultSet result = null; // verificar
			while (result.next()) {
				var cityEntityTmp = new CityEntity();
				cityEntityTmp.setId(UUIDHelper.convertToUUID("id"));
				cityEntityTmp.setName(result.getNString("name"));

				resulSelect.add(cityEntityTmp);
			} // Lo ejecunta tanto resultados tenga

		} catch (final SQLException exception) {
			var userMessage = "Por favor intente de nuevo y si el problema persiste ";
			var technicalMessage = "Se ha presentado un problema al tratar de consultar la informacion de los paises en el filtro deseado en la base de datps SQL server, porfavor valide el log de errores";

			throw DataPostuMOTException.crear(userMessage, technicalMessage, exception);
		}

		return resulSelect;
	}
	
	private void createSelect(final StringBuilder statement) {
		statement.append("SELECT id,nombre,departamento_id ");
	}

	private void createFrom(final StringBuilder statement) {
		statement.append("FROM city ");
	}

	private void createOrderBy(final StringBuilder statement) {
		statement.append("ORDER BY nombre ASC ");
	}

	private void createWhere(final StringBuilder statement, final CityEntity filter, final List<Object> parameters) {
		if (!ObjectHelper.isNull(filter)) {
			if (UUIDHelper.isDefault(filter.getId())) {
				statement.append("WHERE id = ? ");
			}

			if (!TextHelper.isEmptyapplyingTrim(filter.getName())) {
				statement.append("WHERE ");
				statement.append("NOMBRE = ? ");
				parameters.add(filter.getName());
			}
		}
		statement.append("ORDER BY nombre ASC ");
	}
	
}
