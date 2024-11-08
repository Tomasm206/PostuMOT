package co.edu.uco.postumot.geografias.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.postumot.common.data.dao.impl.sql.SqlDAO;
import co.edu.uco.postumot.geografias.data.dao.StateDAO;
import co.edu.uco.postumot.geografias.entity.StateEntity;


public class StateSqlServerDAO extends SqlDAO implements StateDAO {

	protected StateSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public StateEntity findByID(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateEntity> findByFilter(StateEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}
}
