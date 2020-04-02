package br.com.mind5.model.action;

import java.util.List;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;

public interface ActionVisitorAction<T extends InfoRecord> {
	public DeciResult<T> executeTransformation(List<T> recordInfos);
}
