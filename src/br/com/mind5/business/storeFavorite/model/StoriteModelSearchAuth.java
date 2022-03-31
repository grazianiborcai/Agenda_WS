package br.com.mind5.business.storeFavorite.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.decisionTree.StoriteRootSearchAuth;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoriteModelSearchAuth extends ModelTemplate<StoriteInfo> {

	public StoriteModelSearchAuth(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StoriteInfo.class);
	}
	
	
	
	@Override protected DeciTree<StoriteInfo> getDecisionTreeHook(DeciTreeOption<StoriteInfo> option) {
		return new StoriteRootSearchAuth(option);
	}
}
