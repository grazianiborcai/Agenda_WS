package br.com.gda.sql;

import java.util.List;

public interface SqlStmtExecFactory<T> {
	public SqlStmtExec<T> getStmtExec(List<SqlStmtExecOption<T>> sqlStmtOptions);
}
