package co.edu.uco.postumot.company.data.dao;

import java.util.UUID;

import co.edu.uco.postumot.company.entity.EmpresaEntity;
import co.edu.uco.postumot.postulant.data.dao.CreateDAO;
import co.edu.uco.postumot.postulant.data.dao.DeleteDAO;
import co.edu.uco.postumot.postulant.data.dao.RetrieveDAO;
import co.edu.uco.postumot.postulant.data.dao.UpdateDAO;

public interface EmpresaDAO extends CreateDAO<EmpresaEntity>, RetrieveDAO<EmpresaEntity, UUID>, UpdateDAO<EmpresaEntity>, DeleteDAO<EmpresaEntity>{

}
