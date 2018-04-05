package br.com.gda.sql;

import java.sql.PreparedStatement;

public interface SqlStmtParamTranslator {
	public PreparedStatement translateStmtParam(PreparedStatement stmt);
}
