package br.com.gda.model;

import java.util.List;

import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public interface ModelStmtExec<T> {
	public SqlStmtExec<T> getStmtExec(List<SqlStmtExecOption<T>> sqlStmtOptions);
}
