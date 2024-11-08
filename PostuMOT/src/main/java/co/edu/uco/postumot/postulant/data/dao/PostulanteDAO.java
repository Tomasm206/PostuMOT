package co.edu.uco.postumot.postulant.data.dao;

import java.util.UUID;

import co.edu.uco.postumot.common.data.dao.CreateDAO;
import co.edu.uco.postumot.common.data.dao.DeleteDAO;
import co.edu.uco.postumot.common.data.dao.RetrieveDAO;
import co.edu.uco.postumot.common.data.dao.UpdateDAO;
import co.edu.uco.postumot.postulant.entity.PostulanteEntity;

public interface PostulanteDAO extends CreateDAO<PostulanteEntity>,RetrieveDAO<PostulanteEntity, UUID>, UpdateDAO<PostulanteEntity>, DeleteDAO<UUID>{

}
