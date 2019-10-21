package br.com.mind5.business.employeePosition.model;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.decisionTree.RootEmposSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposModelSelect extends ModelTemplate<EmposInfo> {

	public EmposModelSelect(EmposInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmposInfo> getDecisionTreeHook(DeciTreeOption<EmposInfo> option) {
		return new RootEmposSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
