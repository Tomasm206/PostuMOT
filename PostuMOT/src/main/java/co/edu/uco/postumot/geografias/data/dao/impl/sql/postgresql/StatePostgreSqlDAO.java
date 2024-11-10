package co.edu.uco.postumot.geografias.data.dao.impl.sql.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.postumot.common.data.dao.impl.sql.SqlDAO;
import co.edu.uco.postumot.geografias.data.dao.StateDAO;
import co.edu.uco.postumot.geografias.entity.StateEntity;


public class StatePostgreSqlDAO extends SqlDAO implements StateDAO {

	public StatePostgreSqlDAO(final Connection connection) {
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
