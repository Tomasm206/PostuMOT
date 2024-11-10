package co.edu.uco.postumot.common.data.dao.impl.sql.sqlserver;

import java.sql.Connection;

import co.edu.uco.crosscutting.helpers.SqlConnectionHelper;
import co.edu.uco.postumot.geografias.data.dao.CityDAO;
import co.edu.uco.postumot.geografias.data.dao.CountryDAO;
import co.edu.uco.postumot.geografias.data.dao.StateDAO;
import co.edu.uco.postumot.postulant.data.dao.DAOFactory;
import co.edu.uco.postumot.postulant.data.dao.PostulanteDAO;
import co.edu.uco.postumot.postulant.data.dao.TipoDocumentoDAO;
import co.edu.uco.postumot.postulant.data.dao.impl.sql.postgresql.TipoDocumentoPostgreSqlDAO;

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
//		return new ();
//	}
//
//	@Override
//	public StateDAO getStateDAO() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public CountryDAO getCountryDAO() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
