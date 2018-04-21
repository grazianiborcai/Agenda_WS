package br.com.gda.model;

import java.sql.Connection;

import br.com.gda.model.decisionTree.DecisionTreeFactory;

public final class ModelOption<T> {
	public Class<T> infoRecordClass; 
	public DecisionTreeFactory<T> decisionTreeFactory;
	public Connection conn;
	public String schemaName;
}
