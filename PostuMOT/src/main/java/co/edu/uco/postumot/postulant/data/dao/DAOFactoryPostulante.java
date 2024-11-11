package co.edu.uco.postumot.postulant.data.dao;

import co.edu.uco.postumot.common.crosscutting.exception.BusinessLogicPostuMOTException;
import co.edu.uco.postumot.common.data.dao.enums.DAOSource;
import co.edu.uco.postumot.postulant.data.dao.impl.sql.postgresql.PostgreSqlDAOFactory;

public abstract class DAOFactoryPostulante {

	public final static DAOFactoryPostulante getFactory(final DAOSource source) {
	    if (source == DAOSource.POSTGRESQL) {
	        return new PostgreSqlDAOFactory();  // Debes tener esta clase implementada
	    }else {
	    	throw BusinessLogicPostuMOTException.crear("No se pudo encontrar la fuente de datos solicitada. Intente con otra fuente o contacte al soporte..."
	    			,"Se intentó obtener una fábrica para la fuente de datos no reconocida:" + source);
	    }
	    
	}


	protected abstract void openConnection();

	public abstract void initTransaction();

	public abstract void commitTransaction();

	public abstract void rollbackTransaction();
	
	public abstract TipoDocumentoDAO getTipoDocumentoDAO();
	
	public abstract PostulanteDAO getPostulanteDAO();
	
	public abstract void closeConnection();
}
