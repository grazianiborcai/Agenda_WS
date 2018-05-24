package br.com.gda.model.decisionTree;

public interface DeciActionFactory<T> {
	public DeciAction<T> getInstance(DeciTreeOption<T> option);
}
