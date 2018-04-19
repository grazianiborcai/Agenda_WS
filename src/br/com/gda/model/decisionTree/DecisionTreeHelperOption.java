package br.com.gda.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.checker.ModelChecker;

public final class DecisionTreeHelperOption<T> {
	public List<T> recordInfos;
	public Connection conn;
	public String schemaName;
	public ModelChecker<T> visitorChecker;
	public List<DecisionActionAdapter<T>> actionsOnPassed;
	public List<DecisionActionAdapter<T>> actionsOnFailed;	
}
