package co.edu.uco.postumot.common.data.dao.impl.sql.sqlserver;

import java.sql.Connection;

import co.edu.uco.crosscutting.helpers.SqlConnectionHelper;
import co.edu.uco.postumot.common.data.dao.DAOFactory;

public final class SqlServerDAOFactory extends DAOFactory {

	private Connection connection;

	public SqlServerDAOFactory() {
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

//	@Override
//	public CityDAO getCityDAO() {
//		return new CitySqlServerDAO(connection);
//	}
//
//	@Override
//	public StateDAO getStateDAO() {
//		return new StateSqlServerDAO(connection);
//	}
//
//	@Override
//	public CountryDAO getCountryDAO() {
//		return new CountrySqlServerDAO(connection);
//	}

}
