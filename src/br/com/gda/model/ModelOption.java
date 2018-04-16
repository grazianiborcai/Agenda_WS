package br.com.gda.model;

import br.com.gda.model.checker.ModelChecker;
import br.com.gda.sql.SqlStmtExecFactory;

public final class ModelOption<T> {
	public Class<T> infoRecordClass; 
	public ModelChecker<T> visitorChecker;
	public SqlStmtExecFactory<T> visitorStmtExec;
}
