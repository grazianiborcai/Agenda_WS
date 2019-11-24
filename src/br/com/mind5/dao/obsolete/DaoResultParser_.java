package br.com.mind5.dao.obsolete;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DaoResultParser_<T> {
	public List<T> parseResult(ResultSet resultSet, long lastId) throws SQLException;
}
