package br.com.mind5.model.action;

import java.util.List;

import br.com.mind5.model.decisionTree.DeciResult;

public interface ActionVisitorAction<T> {
	public DeciResult<T> executeTransformation(List<T> recordInfos);
}
