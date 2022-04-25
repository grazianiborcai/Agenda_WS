package br.com.mind5.business.employeeLunchTime.model;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.decisionTree.EmplutmRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmModelSelect extends ModelTemplate<EmplutmInfo> {

	public EmplutmModelSelect(EmplutmInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmplutmInfo> getDecisionTreeHook(DeciTreeOption<EmplutmInfo> option) {
		return new EmplutmRootSelect(option);
	}
}
