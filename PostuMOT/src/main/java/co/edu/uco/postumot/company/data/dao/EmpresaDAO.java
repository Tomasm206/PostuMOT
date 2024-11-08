package co.edu.uco.postumot.company.data.dao;

import java.util.UUID;

import co.edu.uco.postumot.common.data.dao.CreateDAO;
import co.edu.uco.postumot.common.data.dao.DeleteDAO;
import co.edu.uco.postumot.common.data.dao.RetrieveDAO;
import co.edu.uco.postumot.common.data.dao.UpdateDAO;
import co.edu.uco.postumot.company.entity.EmpresaEntity;

public interface EmpresaDAO extends CreateDAO<EmpresaEntity>, RetrieveDAO<EmpresaEntity, UUID>, UpdateDAO<EmpresaEntity>, DeleteDAO<EmpresaEntity>{

}
