package br.com.mind5.business.store.model;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.decisionTree.RootStoreDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreModelDelete extends ModelTemplate<StoreInfo> {

	public StoreModelDelete(StoreInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StoreInfo> getDecisionTreeHook(DeciTreeOption<StoreInfo> option) {
		return new RootStoreDelete(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
