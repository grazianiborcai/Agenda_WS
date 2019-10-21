package br.com.mind5.business.employeePosition.model;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.decisionTree.RootEmposDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposModelDelete extends ModelTemplate<EmposInfo> {

	public EmposModelDelete(EmposInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmposInfo> getDecisionTreeHook(DeciTreeOption<EmposInfo> option) {
		return new RootEmposDelete(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
