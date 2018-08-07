package br.com.gda.dao;

import java.util.List;

public interface DaoStmtExecFactory<T> {	//TODO: Remover
	public DaoStmtExec<T> getStmtExec(List<DaoStmtExecOption<T>> sqlStmtOptions);
}
