package br.com.mind5.business.employeePosition.model;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.decisionTree.RootEmposSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposModelSearch extends ModelTemplate<EmposInfo> {

	public EmposModelSearch(EmposInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmposInfo> getDecisionTreeHook(DeciTreeOption<EmposInfo> option) {
		return new RootEmposSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
