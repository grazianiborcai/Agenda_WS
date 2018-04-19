package br.com.gda.model;

import java.sql.Connection;

import br.com.gda.model.decisionTree.DecisionTreeFactory;

public final class ModelOptionV2<T> {
	public Class<T> infoRecordClass; 
	public DecisionTreeFactory<T> decisionTreeFactory;
	public boolean closeTransaction; // TODO: Remover
	public Connection conn;
	public String schemaName;
	
	
	public ModelOptionV2() {
		this.closeTransaction = false;
	}
}
