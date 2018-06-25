package br.com.gda.model.decisionTree;

import java.util.List;

public interface DeciActionTransVisitor<T> {
	public List<T> executeTransformation(List<T> recordInfos);
}
