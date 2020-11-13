package br.com.mind5.model.action;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;

public interface ActionVisitor<T extends InfoRecord> {
	public DeciResult<T> executeTransformation();
	
	public void close();
}
