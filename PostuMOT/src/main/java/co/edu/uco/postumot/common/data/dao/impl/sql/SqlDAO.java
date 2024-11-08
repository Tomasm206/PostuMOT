package co.edu.uco.postumot.common.data.dao.impl.sql;

import java.sql.Connection;
import co.edu.uco.crosscutting.helpers.SqlConnectionHelper;

public class SqlDAO {
	// Good

	private Connection connection;

	protected SqlDAO(final Connection connection) {
		setConnection(connection);
	}
	// Busca que unicamente los que heredan puedan acceder al setConection

	protected Connection getConnection() {
		return connection;
	}

	private void setConnection(final Connection connection) {
		SqlConnectionHelper.validateIfConnectionIsClosed(connection);
		this.connection = connection;
	}

	private void validateIfConnectionIsOpen(final Connection connection) {
		SqlConnectionHelper.validateIfConnectionIsClosed(connection);
	}
	// validamos si la conexion esta cerrada "null"
	// seguido de eso, unicamente necesitamos conexiones abiertas
	// se crea un metodo que nos valide eso.
}
