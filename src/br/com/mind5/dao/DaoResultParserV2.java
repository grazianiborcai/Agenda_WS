package br.com.mind5.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DaoResultParserV2<T> {
	public List<T> parseResult(T RecordInfo, ResultSet resultSet, long lastId) throws SQLException;
}
