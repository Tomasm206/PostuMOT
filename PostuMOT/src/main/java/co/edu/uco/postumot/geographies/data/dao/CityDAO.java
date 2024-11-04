package co.edu.uco.postumot.geographies.data.dao;

import java.util.UUID;

import co.edu.uco.postumot.common.dao.CreateDAO;
import co.edu.uco.postumot.common.dao.DeleteDAO;
import co.edu.uco.postumot.common.dao.RetrieveDAO;
import co.edu.uco.postumot.common.dao.UpdateDAO;
import co.edu.uco.postumot.geographies.entity.CityEntity;



public interface CityDAO
		extends CreateDAO<CityEntity>, RetrieveDAO<CityEntity, UUID>, UpdateDAO<CityEntity>, DeleteDAO<UUID> {
}
