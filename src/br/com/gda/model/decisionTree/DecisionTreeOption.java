package br.com.gda.model.decisionTree;

import java.sql.Connection;
import java.util.List;

public final class DecisionTreeOption<T> {
	public List<T> recordInfos;
	public Connection conn;
	public String schemaName;
}
