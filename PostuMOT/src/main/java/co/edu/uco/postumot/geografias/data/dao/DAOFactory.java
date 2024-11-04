package co.edu.uco.postumot.geografias.data.dao;

import co.edu.uco.postumot.geografias.data.dao.enums.DAOSource;
import co.edu.uco.postumot.geographies.data.dao.CityDAO;
import co.edu.uco.postumot.geographies.data.dao.CountryDAO;
import co.edu.uco.postumot.geographies.data.dao.StateDAO;

public abstract class DAOFactory {

	public final static DAOFactory getFactory(final DAOSource source) {
		return null;
	}

	protected abstract void openConnection();

	public abstract void initTransaction();

	public abstract void commitTransaction();

	public abstract void rollbackTransaction();

	public abstract void closeConnection();

	public abstract CityDAO getCityDAO();

	public abstract StateDAO getStateDAO();

	public abstract CountryDAO getCountryDAO();

}
