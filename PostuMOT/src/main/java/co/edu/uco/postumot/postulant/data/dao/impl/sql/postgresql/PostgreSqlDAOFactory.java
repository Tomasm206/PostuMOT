package co.edu.uco.postumot.postulant.data.dao.impl.sql.postgresql;

import java.sql.Connection;

import co.edu.uco.crosscutting.helpers.SqlConnectionHelper;
import co.edu.uco.postumot.postulant.data.dao.DAOFactoryPostulante;
import co.edu.uco.postumot.postulant.data.dao.PostulanteDAO;
import co.edu.uco.postumot.postulant.data.dao.TipoDocumentoDAO;

public final class PostgreSqlDAOFactory extends DAOFactoryPostulante {

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
		System.out.println("Se cierra la conexion");
	}

	@Override
	public PostulanteDAO getPostulanteDAO() {
		return new PostulantePostgreSqlDAO(connection);
	}
	
	@Override
	public TipoDocumentoDAO getTipoDocumentoDAO() {
		return new TipoDocumentoPostgreSqlDAO(connection);
	}

}
