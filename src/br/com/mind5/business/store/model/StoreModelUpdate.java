package br.com.mind5.business.store.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.decisionTree.RootStoreUpdate;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreModelUpdate extends ModelTemplate<StoreInfo> {

	public StoreModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StoreInfo.class);
	}
	
	
	
	@Override protected DeciTree<StoreInfo> getDecisionTreeHook(DeciTreeOption<StoreInfo> option) {
		return new RootStoreUpdate(option);
	}
}
