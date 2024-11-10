package co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.impl;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.postumot.common.crosscutting.exception.BusinessLogicPostuMOTException;
import co.edu.uco.postumot.postulant.bussineslogic.adapter.entity.PostulanteEntityAdapter;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.UpdatePostulante;
import co.edu.uco.postumot.postulant.data.dao.DAOFactoryPostulante;
import co.edu.uco.postumot.postulant.domain.PostulanteDomain;
import co.edu.uco.postumot.postulant.entity.PostulanteEntity;

public final class UpdatePostulanteImpl implements UpdatePostulante{
	
	private DAOFactoryPostulante daoFactory;
	
	public UpdatePostulanteImpl(DAOFactoryPostulante daoFactory) {
		setDaoFactory(daoFactory);
	}
	
	@Override
	public void execute(PostulanteDomain data) {
		
		var postulanteEntity = PostulanteEntityAdapter.getPostulanteEntityAdapter().adaptSource(data);
		daoFactory.getPostulanteDAO().update(postulanteEntity);
	}
	
	public void setDaoFactory(final DAOFactoryPostulante daoFactory) {
		if(ObjectHelper.isNull(daoFactory)) {
			var userMessage = "Se ha presentado un problema inesperado, tratando de llevar a cabo la modificacion de la informacion del postulante. Por favor intente de nuevo y si el problema persiste comuniquese con atencion al cliente...";
			var technicalMessage = "El dao factory requerido para crear la clase que actualiza el postulante llegó nula.";
			throw BusinessLogicPostuMOTException.crear(userMessage, technicalMessage);
		}
		this.daoFactory = daoFactory;
	}
}
