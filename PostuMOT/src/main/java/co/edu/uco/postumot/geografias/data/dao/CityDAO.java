package co.edu.uco.postumot.geografias.data.dao;

import java.util.UUID;

import co.edu.uco.postumot.common.data.dao.CreateDAO;
import co.edu.uco.postumot.common.data.dao.DeleteDAO;
import co.edu.uco.postumot.common.data.dao.RetrieveDAO;
import co.edu.uco.postumot.common.data.dao.UpdateDAO;
import co.edu.uco.postumot.geografias.entity.CityEntity;



public interface CityDAO
		extends CreateDAO<CityEntity>, RetrieveDAO<CityEntity, UUID>, UpdateDAO<CityEntity>, DeleteDAO<UUID> {
}
