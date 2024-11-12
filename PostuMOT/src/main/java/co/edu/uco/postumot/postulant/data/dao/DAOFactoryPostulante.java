package co.edu.uco.postumot.postulant.data.dao;

import co.edu.uco.postumot.common.data.dao.enums.DAOSource;
import co.edu.uco.postumot.postulant.data.dao.impl.sql.postgresql.PostgreSqlDAOFactory;

public abstract class DAOFactoryPostulante {

	public final static DAOFactoryPostulante getFactory(final DAOSource source) {
		
		return new PostgreSqlDAOFactory();
	}

	protected abstract void openConnection();

	public abstract void initTransaction();

	public abstract void commitTransaction();

	public abstract void rollbackTransaction();

	public abstract void closeConnection();

	public abstract TipoDocumentoDAO getTipoDocumentoDAO();

	public abstract PostulanteDAO getPostulanteDAO();

}
