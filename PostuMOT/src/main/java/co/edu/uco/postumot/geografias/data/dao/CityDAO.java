package co.edu.uco.postumot.geografias.data.dao;

import java.util.UUID;

import co.edu.uco.postumot.geografias.entity.CityEntity;
import co.edu.uco.postumot.postulant.data.dao.CreateDAO;
import co.edu.uco.postumot.postulant.data.dao.DeleteDAO;
import co.edu.uco.postumot.postulant.data.dao.RetrieveDAO;
import co.edu.uco.postumot.postulant.data.dao.UpdateDAO;



public interface CityDAO
		extends CreateDAO<CityEntity>, RetrieveDAO<CityEntity, UUID>, UpdateDAO<CityEntity>, DeleteDAO<UUID> {
}
