package co.edu.uco.postumot.postulant.data.dao.impl.sql.postgresql;

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
import co.edu.uco.postumot.postulant.data.dao.PostulanteDAO;
import co.edu.uco.postumot.postulant.entity.PostulanteEntity;

public final class PostulantePostgreSqlDAO extends SqlDAO implements PostulanteDAO {

	protected PostulantePostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(final PostulanteEntity data) {
		final StringBuilder statement = new StringBuilder();
		statement.append(
				"INSERT INTO postulante(id, documento, primernombre, segundonombre, primerapellido, segundoapellido, telefono, correo, genero, tipodocumento_id, city_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		// Coloca un breakpoint aquí para verificar que la consulta se está construyendo
		// correctamente

		System.out.println("Consulta SQL construida: " + statement.toString());

		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())) {
			
			System.out.println(data.getCity().getId());
			System.out.println(data.getTipoDocumento().getId());
			
			preparedStatement.setObject(1, data.getId());
			preparedStatement.setInt(2, data.getDocumento());
			preparedStatement.setString(3, data.getFirstName());
			preparedStatement.setString(4, data.getSecondName());
			preparedStatement.setString(5, data.getLastName());
			preparedStatement.setString(6, data.getLastSecondName());
			preparedStatement.setInt(7, data.getPhone());
			preparedStatement.setString(8, data.getEmail());
			preparedStatement.setString(9, data.getSex());
			preparedStatement.setObject(10, data.getTipoDocumento().getId());
			preparedStatement.setObject(11, data.getCity().getId());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de llevar a cabo el registro de la información del nuevo postulante. Por favor intente de nuevo y si el problema persiste reporte la novedad...";
			var technicalMessage = "Se ha presentado un problema al tratar de registrar la informaciòn del nuevo país en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			throw DataPostuMOTException.crear(userMessage, technicalMessage, exception);
		}
	}

	@Override
	public PostulanteEntity findByID(UUID id) {
		var postulanteEntityFilter = new PostulanteEntity();
		postulanteEntityFilter.setId(id);

		var result = findByFilter(postulanteEntityFilter);

		return (result.isEmpty()) ? new PostulanteEntity() : result.get(0);
	}

	@Override
	public List<PostulanteEntity> findAll() {
		return findByFilter(new PostulanteEntity());
	}

//	@Override
//	public List<PostulanteEntity> findAll() {
//	    List<PostulanteEntity> postulantes = new ArrayList<>();
//	    String sql = "SELECT id, documento, primernombre, segundonombre, primerapellido, segundoapellido, telefono, correo, genero, tipodocumento_id, city_id FROM postulante";
//
//	    try (PreparedStatement statement = connection.prepareStatement(sql);
//	         ResultSet resultSet = statement.executeQuery()) {
//
//	        while (resultSet.next()) {
//	            PostulanteEntity postulante = new PostulanteEntity();
//	            postulante.setId(resultSet.getObject("id", UUID.class));
//	            postulante.setDocumento(resultSet.getInt("documento"));
//	            postulante.setFirstName(resultSet.getString("primernombre"));
//	            postulante.setSecondName(resultSet.getString("segundonombre"));
//	            postulante.setLastName(resultSet.getString("primerapellido"));
//	            postulante.setLastSecondName(resultSet.getString("segundoapellido"));
//	            postulante.setPhone(resultSet.getInt("telefono"));
//	            postulante.setEmail(resultSet.getString("correo"));
//	            postulante.setSex(resultSet.getString("genero"));
//	            postulante.setTipoDocumento(resultSet.getObject("tipodocumento_id", UUID.class));
//	            postulante.setCity(resultSet.getObject("city_id", UUID.class));
//	            postulantes.add(postulante);
//	        }
//	    } catch (final SQLException exception) {
//	        // Manejo de excepciones apropiado
//	        throw DataPostuMOTException.crear("Error al consultar postulantes");
//	    }
//	    return postulantes;
//	}

	@Override
	public List<PostulanteEntity> findByFilter(PostulanteEntity filter) {
		final var statement = new StringBuilder();
		final var parameters = new ArrayList<>();
		final var resulSelect = new ArrayList<PostulanteEntity>(); // Valor de los resultados almacenados
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
				var countryEntityTmp = new PostulanteEntity();
				countryEntityTmp.setId(UUIDHelper.convertToUUID("id"));
				countryEntityTmp.setDocumento(result.getInt(11111));
				countryEntityTmp.setFirstName(result.getNString("name"));

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
		statement.append("SELECT id, documento, primernombre");
	}

	private void createFrom(final StringBuilder statement) {
		statement.append("FROM postulante ");
	}

	private void createOrderBy(final StringBuilder statement) {
		statement.append("ORDER BY primernombre ASC ");
	}

	private void createWhere(final StringBuilder statement, final PostulanteEntity filter,
			final List<Object> parameters) {
		if (!ObjectHelper.isNull(filter)) {
			if (UUIDHelper.isDefault(filter.getId())) {
				statement.append("WHERE id = ? ");
			}

			if (!TextHelper.isEmptyapplyingTrim(filter.getFirstName())) {
				statement.append("WHERE ");
				statement.append("NAME = ? ");
				parameters.add(filter.getFirstName());
			}
		}
		statement.append("ORDER BY name ASC ");
	}

	@Override
	public void update(final PostulanteEntity data) {
		final StringBuilder statement = new StringBuilder();
		statement.append(
				"UPDATE postulante SET documento = ?, primernombre = ?, segundonombre = ?, primerapellido = ?, segundoapellido = ?, telefono = ?, correo = ?, genero = ?, city_id = ?, tipodocumento_id = ? WHERE id = ?");

		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())) {

			preparedStatement.setString(1, data.getFirstName());
			preparedStatement.setInt(2, data.getDocumento());
			preparedStatement.setString(3, data.getFirstName());
			preparedStatement.setString(4, data.getSecondName());
			preparedStatement.setString(5, data.getLastName());
			preparedStatement.setString(6, data.getLastSecondName());
			preparedStatement.setLong(7, data.getPhone());
			preparedStatement.setString(8, data.getEmail());
			preparedStatement.setString(9, data.getSex());
			preparedStatement.setObject(10, data.getCity().getId());
			preparedStatement.setObject(11, data.getTipoDocumento().getId());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema";
			var technicalMessage = "Se ha presentado un problema";

			throw DataPostuMOTException.crear(userMessage, technicalMessage, exception);
		}
	}

	@Override
	public void delete(final UUID data) {
		final StringBuilder statement = new StringBuilder();
		statement.append("DELETE FROM postulante WHERE id = ?");

		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())) {

			preparedStatement.setObject(1, data);

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema";
			var technicalMessage = "Se ha presentado un problema";

			throw DataPostuMOTException.crear(userMessage, technicalMessage, exception);
		}
	}
}
