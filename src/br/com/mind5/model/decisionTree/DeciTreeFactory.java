package br.com.mind5.model.decisionTree;

public interface DeciTreeFactory<T> {
	public DeciTree<T> getInstance(DeciTreeOption<T> option);
}
