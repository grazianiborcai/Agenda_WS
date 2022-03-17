package br.com.mind5.business.store.model;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.decisionTree.StoreRootActivate;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreModelActivate extends ModelTemplate<StoreInfo> {

	public StoreModelActivate(StoreInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StoreInfo> getDecisionTreeHook(DeciTreeOption<StoreInfo> option) {
		return new StoreRootActivate(option);
	}
}
