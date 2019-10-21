package br.com.mind5.business.storeList.model;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.RootStolisSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
