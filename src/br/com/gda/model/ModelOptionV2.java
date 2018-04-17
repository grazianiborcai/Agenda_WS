package br.com.gda.model;

import br.com.gda.model.decisionTree.DecisionTreeFactory;

public final class ModelOptionV2<T> {
	public Class<T> infoRecordClass; 
	public DecisionTreeFactory<T> decisionTreeFactory;
}
