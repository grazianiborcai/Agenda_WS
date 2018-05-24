package br.com.gda.model.decisionTree;

public interface DeciTreeFactory<T> {
	public DeciTree<T> getInstance(DeciTreeOption<T> option);
}
