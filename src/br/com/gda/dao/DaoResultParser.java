package br.com.gda.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DaoResultParser<T> {
	public List<T> parseResult(ResultSet resultSet, long lastId) throws SQLException;
}
