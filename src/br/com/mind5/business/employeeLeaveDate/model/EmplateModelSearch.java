package br.com.mind5.business.employeeLeaveDate.model;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.RootEmplateSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplateModelSearch extends ModelTemplate<EmplateInfo> {

	public EmplateModelSearch(EmplateInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmplateInfo> getDecisionTreeHook(DeciTreeOption<EmplateInfo> option) {
		return new RootEmplateSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
