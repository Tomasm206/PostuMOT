package co.edu.uco.postumot.geografias.data.dao.impl.sql.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.lang.model.element.VariableElement;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.crosscutting.exception.DataPostuMOTException;
import co.edu.uco.postumot.common.data.dao.impl.sql.SqlDAO;
import co.edu.uco.postumot.geografias.data.dao.CountryDAO;
import co.edu.uco.postumot.geografias.entity.CountryEntity;



public class CountryPostgreSqlDAO extends SqlDAO implements CountryDAO {

	protected CountryPostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	public CountryEntity findById(final UUID id) {
		return null;
	}

	@Override
	public CountryEntity findByID(UUID id) {
		var countryEntityFilter = new CountryEntity();
		countryEntityFilter.setId(id);

		var result = findByFilter(countryEntityFilter);

		return (result.isEmpty()) ? new CountryEntity() : result.get(0);
	}

	@Override
	public List<CountryEntity> findAll() {
		return findByFilter(new CountryEntity());
	}

	@Override
	public List<CountryEntity> findByFilter(final CountryEntity filter) {
		final var statement = new StringBuilder();
		final var parameters = new ArrayList<>();
		final var resulSelect = new ArrayList<CountryEntity>(); // Valor de los resultados almacenados
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
				var countryEntityTmp = new CountryEntity();
				countryEntityTmp.setId(UUIDHelper.convertToUUID("id"));
				countryEntityTmp.setName(result.getNString("name"));

				resulSelect.add(countryEntityTmp);
			} // Lo ejecunta tanto resultados tenga

		} catch (final SQLException exception) {
			var userMessage = "Por favor intente de nuevo y si el problema persiste ";
			var technicalMessage = "Se ha presentado un problema al tratar de consultar la informacion de los paises en el filtro deseado en la base de datps SQL server, porfavor valide el log de errores";

			throw DataPostuMOTException.crear(userMessage, technicalMessage, exception);
		}

		return resulSelect;
	}

	private void createSelect(final StringBuilder statement) {
		statement.append("SELECT id,name ");
	}

	private void createFrom(final StringBuilder statement) {
		statement.append("FROM Country ");
	}

	private void createOrderBy(final StringBuilder statement) {
		statement.append("ORDER BY name ASC ");
	}

	private void createWhere(final StringBuilder statement, final CountryEntity filter, final List<Object> parameters) {
		if (!ObjectHelper.isNull(filter)) {
			if (UUIDHelper.isDefault(filter.getId())) {
				statement.append("WHERE id = ? ");
			}

			if (!TextHelper.isEmptyapplyingTrim(filter.getName())) {
				statement.append("WHERE ");
				statement.append("NAME = ? ");
				parameters.add(filter.getName());
			}
		}
		statement.append("ORDER BY name ASC ");
	}
}
