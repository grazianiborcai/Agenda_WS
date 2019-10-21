package br.com.mind5.business.storeLeaveDate.model;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.decisionTree.RootStolateSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
