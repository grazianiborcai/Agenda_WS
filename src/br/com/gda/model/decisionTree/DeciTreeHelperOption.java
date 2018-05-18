package br.com.gda.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.checker.ModelChecker;

public final class DeciTreeHelperOption<T> {
	public List<T> recordInfos;
	public Connection conn;
	public String schemaName;
	public ModelChecker<T> visitorChecker;
	public List<DeciAction<T>> actionsOnPassed;
	public List<DeciAction<T>> actionsOnFailed;	
}
