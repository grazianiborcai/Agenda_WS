package br.com.gda.model;

import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.decisionTree.DecisionTreeFactory;
import br.com.gda.sql.SqlStmtExecFactory;

public final class ModelOptionV2<T> {
	public Class<T> infoRecordClass; 				
	public ModelChecker<T> visitorChecker;			//###
	public SqlStmtExecFactory<T> visitorStmtExec; 	//###
	public DecisionTreeFactory<T> decisionTreeFactory;
}
