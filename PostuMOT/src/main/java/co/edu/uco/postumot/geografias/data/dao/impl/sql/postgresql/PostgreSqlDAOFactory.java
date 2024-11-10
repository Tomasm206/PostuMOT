package co.edu.uco.postumot.geografias.data.dao.impl.sql.postgresql;

import java.sql.Connection;

import co.edu.uco.crosscutting.helpers.SqlConnectionHelper;
import co.edu.uco.postumot.geografias.data.dao.CityDAO;
import co.edu.uco.postumot.geografias.data.dao.CountryDAO;
import co.edu.uco.postumot.geografias.data.dao.DAOFactoryGeografias;
import co.edu.uco.postumot.geografias.data.dao.StateDAO;

final class PostgreSqlDAOFactory extends DAOFactoryGeografias {

	private Connection connection;

	public PostgreSqlDAOFactory() {
		openConnection();
	}

	@Override
	protected void openConnection() {
		SqlConnectionHelper.validateIfConnectionIsOpen(connection);
		var connectionString = "jdbc:postgresql://localhost:5432/postumot?user=postgres&password=1234";
		connection = SqlConnectionHelper.openConnection(connectionString);
	}

	@Override
	public void initTransaction() {
		SqlConnectionHelper.initTransaction(connection);
	}

	@Override
	public void commitTransaction() {
		SqlConnectionHelper.commitTransaction(connection);
	}

	@Override
	public void rollbackTransaction() {
		SqlConnectionHelper.rollbackTransaction(connection);
	}

	@Override
	public void closeConnection() {
		SqlConnectionHelper.closeConnection(connection);
	}

	@Override
	public CityDAO getCityDAO() {
		return new CityPostgreSqlDAO(connection);
	}

	@Override
	public StateDAO getStateDAO() {
		return new StatePostgreSqlDAO(connection);
	}

	@Override
	public CountryDAO getCountryDAO() {
		return new CountryPostgreSqlDAO(connection);
	}
}
