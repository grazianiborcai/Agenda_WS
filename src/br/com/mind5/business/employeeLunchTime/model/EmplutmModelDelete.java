package br.com.mind5.business.employeeLunchTime.model;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.decisionTree.EmplutmRootDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmModelDelete extends ModelTemplate<EmplutmInfo> {

	public EmplutmModelDelete(EmplutmInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmplutmInfo> getDecisionTreeHook(DeciTreeOption<EmplutmInfo> option) {
		return new EmplutmRootDelete(option);
	}
}
