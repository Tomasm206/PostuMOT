package co.edu.uco.postumot.postulant.data.dao;

import java.util.UUID;

import co.edu.uco.postumot.postulant.data.dao.crud.CreateDAO;
import co.edu.uco.postumot.postulant.data.dao.crud.DeleteDAO;
import co.edu.uco.postumot.postulant.data.dao.crud.RetrieveDAO;
import co.edu.uco.postumot.postulant.data.dao.crud.UpdateDAO;
import co.edu.uco.postumot.postulant.entity.PostulanteEntity;

public interface PostulanteDAO extends CreateDAO<PostulanteEntity>,RetrieveDAO<PostulanteEntity, UUID>, UpdateDAO<PostulanteEntity>, DeleteDAO<UUID>{

}
