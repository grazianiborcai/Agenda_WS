package br.com.gda.model;

import br.com.gda.model.checker.ModelChecker;

public final class ModelOption<T> {
	public Class<T> infoRecordClass; 
	public ModelChecker<T> visitorChecker;
	public ModelStmtExec<T> visitorStmtExec;
}
