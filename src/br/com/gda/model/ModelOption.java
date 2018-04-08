package br.com.gda.model;

import br.com.gda.model.checker.ModelCheckerAbstract;

public final class ModelOption<T> {
	public Class<T> infoRecordClass; 
	public ModelCheckerAbstract<T> visitorChecker;
	public ModelStmtExec<T> visitorStmtExec;
}
