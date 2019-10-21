package br.com.mind5.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DaoStmtParamTranslator<T> {
	public PreparedStatement translateStmtParam(PreparedStatement stmt, T recordInfo) throws SQLException;
}
