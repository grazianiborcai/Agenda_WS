package br.com.gda.model;

import java.sql.Connection;

import br.com.gda.model.decisionTree.DeciTreeFactory;

public final class ModelOption<T> {
	public Class<T> infoRecordClass; 
	public DeciTreeFactory<T> decisionTreeFactory;
	public Connection conn;
	public String schemaName;
}
