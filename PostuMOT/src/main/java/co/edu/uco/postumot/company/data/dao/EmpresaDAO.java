package co.edu.uco.postumot.company.data.dao;

import java.util.UUID;

import co.edu.uco.postumot.common.dao.CreateDAO;
import co.edu.uco.postumot.common.dao.DeleteDAO;
import co.edu.uco.postumot.common.dao.RetrieveDAO;
import co.edu.uco.postumot.common.dao.UpdateDAO;
import co.edu.uco.postumot.company.entity.EmpresaEntity;

public interface EmpresaDAO extends CreateDAO<EmpresaEntity>, RetrieveDAO<EmpresaEntity, UUID>, UpdateDAO<EmpresaEntity>, DeleteDAO<EmpresaEntity>{

}
