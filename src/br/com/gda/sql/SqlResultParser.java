package br.com.gda.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface SqlResultParser<T> {
	public List<T> parseResult(ResultSet resultSet, long lastId) throws SQLException;
}
