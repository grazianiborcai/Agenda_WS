package br.com.gda.model.obsolete;

import java.sql.Connection;

import br.com.gda.model.decisionTree.DeciTreeFactory;

public final class ModelOption_<T> {
	public Class<T> recordClass; 
	public DeciTreeFactory<T> deciTreeFactory;
	public Connection conn;
	public String schemaName;
}
