package br.com.gda.business.storeLeaveDate.model;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.storeLeaveDate.model.decisionTree.RootStolateSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StolateModelSelect extends ModelTemplate<StolateInfo> {

	public StolateModelSelect(StolateInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StolateInfo> getDecisionTreeHook(DeciTreeOption<StolateInfo> option) {
		return new RootStolateSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
