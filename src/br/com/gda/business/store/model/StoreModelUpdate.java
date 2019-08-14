package br.com.gda.business.store.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.decisionTree.RootStoreUpdate;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StoreModelUpdate extends ModelTemplate<StoreInfo> {

	public StoreModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StoreInfo.class);
	}
	
	
	
	@Override protected DeciTree<StoreInfo> getDecisionTreeHook(DeciTreeOption<StoreInfo> option) {
		return new RootStoreUpdate(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
