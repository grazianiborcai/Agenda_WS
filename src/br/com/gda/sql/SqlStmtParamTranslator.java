package br.com.gda.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SqlStmtParamTranslator<T> {
	public PreparedStatement translateStmtParam(PreparedStatement stmt, T recordInfo) throws SQLException;
}
