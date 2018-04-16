package br.com.gda.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.checker.ModelChecker;

public final class DecisionTreeHelperOption<T> {
	public T recordInfo;			//TODO: remover
	public List<T> recordInfos;
	public Connection conn;
	public String schemaName;
	public ModelChecker<T> visitorChecker;
	public DecisionActionAdapter<T> actionOnPassed;
	public DecisionActionAdapter<T> actionOnFailed;
}
