package br.com.gda.model.decisionTree;

public interface DecisionTreeFactory<T> {
	public DecisionTree<T> getDecisionTree(DecisionTreeOption<T> option);
}
