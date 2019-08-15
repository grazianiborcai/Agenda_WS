package br.com.gda.business.employeeList.model;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.employeeList.model.decisionTree.RootEmplisSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
