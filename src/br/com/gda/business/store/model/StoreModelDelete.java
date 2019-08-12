package br.com.gda.business.store.model;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.decisionTree.RootStoreDelete;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
