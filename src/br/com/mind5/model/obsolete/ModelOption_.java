package br.com.mind5.model.obsolete;

import java.sql.Connection;

import br.com.mind5.model.decisionTree.DeciTreeFactory;

public final class ModelOption_<T> {
	public Class<T> recordClass; 
	public DeciTreeFactory<T> deciTreeFactory;
	public Connection conn;
	public String schemaName;
}
