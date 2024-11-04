package co.edu.uco.postumot.postulant.data.dao;

import java.util.UUID;

import co.edu.uco.postumot.common.dao.CreateDAO;
import co.edu.uco.postumot.common.dao.DeleteDAO;
import co.edu.uco.postumot.common.dao.RetrieveDAO;
import co.edu.uco.postumot.common.dao.UpdateDAO;
import co.edu.uco.postumot.postulant.entity.PostulanteEntity;

public interface PostulanteDAO extends CreateDAO<PostulanteEntity>,RetrieveDAO<PostulanteEntity, UUID>, UpdateDAO<PostulanteEntity>, DeleteDAO<UUID>{

}
