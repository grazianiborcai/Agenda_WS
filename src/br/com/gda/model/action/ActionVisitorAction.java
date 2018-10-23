package br.com.gda.model.action;

import java.util.List;

import br.com.gda.model.decisionTree.DeciResult;

public interface ActionVisitorAction<T> {
	public DeciResult<T> executeTransformation(List<T> recordInfos);
}
