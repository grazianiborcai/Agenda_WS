package br.com.gda.sql;

import java.util.List;

public interface SqlStmtExecFactory<T> {	//TODO: Remover
	public SqlStmtExec<T> getStmtExec(List<SqlStmtExecOption<T>> sqlStmtOptions);
}
