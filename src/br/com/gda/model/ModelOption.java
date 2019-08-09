package br.com.gda.model;

import java.sql.Connection;

import br.com.gda.model.decisionTree.DeciTreeFactory;

public final class ModelOption<T> {
	public Class<T> recordClass; 
	public DeciTreeFactory<T> deciTreeFactory;
	public Connection conn;
	public String schemaName;
}
