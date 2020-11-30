package br.com.mind5.business.store.model;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.decisionTree.RootStoreSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreModelSelect extends ModelTemplate<StoreInfo> {

	public StoreModelSelect(StoreInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StoreInfo> getDecisionTreeHook(DeciTreeOption<StoreInfo> option) {
		return new RootStoreSelect(option);
	}
}
