package br.com.gda.business.storeList.model;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.storeList.model.decisionTree.RootStolisSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StolisModelSelect extends ModelTemplate<StolisInfo> {

	public StolisModelSelect(StolisInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StolisInfo> getDecisionTreeHook(DeciTreeOption<StolisInfo> option) {
		return new RootStolisSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
