package br.com.mind5.business.employeeList.model;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.decisionTree.RootEmplisSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplisModelSelect extends ModelTemplate<EmplisInfo> {

	public EmplisModelSelect(EmplisInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmplisInfo> getDecisionTreeHook(DeciTreeOption<EmplisInfo> option) {
		return new RootEmplisSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
