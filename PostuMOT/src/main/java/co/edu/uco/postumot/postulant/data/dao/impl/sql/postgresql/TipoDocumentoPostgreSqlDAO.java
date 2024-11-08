package co.edu.uco.postumot.postulant.data.dao.impl.sql.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.crosscutting.exception.DataPostuMOTException;
import co.edu.uco.postumot.common.data.dao.impl.sql.SqlDAO;
import co.edu.uco.postumot.postulant.data.dao.TipoDocumentoDAO;
import co.edu.uco.postumot.postulant.entity.TipoDocumentoEntity;

public final class TipoDocumentoPostgreSqlDAO extends SqlDAO implements TipoDocumentoDAO {

	protected TipoDocumentoPostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public TipoDocumentoEntity findByID(final UUID id) {
		var tipoDocumentoEntityFilter = new TipoDocumentoEntity();
		tipoDocumentoEntityFilter.setId(id);
		
		var result = findByFilter(tipoDocumentoEntityFilter);
		return (result.isEmpty()) ? new TipoDocumentoEntity() : result.get(0);
	}

	@Override
	public List<TipoDocumentoEntity> findAll() {
		return findByFilter(new TipoDocumentoEntity());
	}

	@Override
	public List<TipoDocumentoEntity> findByFilter(final TipoDocumentoEntity filter) {
		final var statement = new  StringBuilder();
		final var parameters = new ArrayList<>();
		final var resultSelect = new ArrayList<TipoDocumentoEntity>();
		var statementWasPrepared = false;
		 
		
		createSelect(statement);
		createFrom(statement);
		createWhere(statement, filter, parameters);
		createOrderBy(statement);
		
		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())){
			
			for  (var arrayIndex = 0; arrayIndex < parameters.size(); arrayIndex++) {
				var statementIndex = arrayIndex + 1;
				preparedStatement.setObject(statementIndex, parameters.get(arrayIndex));
			}
			
			  statementWasPrepared = true;
			
			  final var result = preparedStatement.executeQuery(); 
							
			  while(result.next()) {
				var countryEntityTmp = new TipoDocumentoEntity();
				countryEntityTmp.setId(UUIDHelper.convertToUUID(result.getString("id")));
				countryEntityTmp.setName(result.getString("name"));
							
			    resultSelect.add(countryEntityTmp);
		    } 
			
								
		    }catch(final SQLException exception) 
		{
		
			var userMessage = "se ha presentado un problema tratando de llevar a cabo la consulta de los paises en el filtro deseado. por favor intente de nuevo y si el problema persiste reporte la novedad....";
			var technicalMessage = "se ha presentado un problema a tratar de consultar la informacion de los paises del filtro deseado en la base de datos de SQL tratando de ejecutar la setencia SQL que se iba a ejectar .por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			
			if(statementWasPrepared) {
				technicalMessage = "se ha presentado un problema a tratar de consultar la informacion de los paises del filtro deseado en la base de datos de SQL tratando de ejecutar la setencia SQL Definida.por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			}
			
		
			throw DataPostuMOTException.crear(userMessage, technicalMessage, exception);
		 }
		
		return resultSelect;
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

	private void createWhere(final StringBuilder statement, final TipoDocumentoEntity filter, final List<Object> parameters) {
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
