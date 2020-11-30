package br.com.mind5.business.storeFavorite.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.decisionTree.RootStoriteInsertAuth;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoriteModelInsertAuth extends ModelTemplate<StoriteInfo> {

	public StoriteModelInsertAuth(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StoriteInfo.class);
	}
	
	
	
	@Override protected DeciTree<StoriteInfo> getDecisionTreeHook(DeciTreeOption<StoriteInfo> option) {
		return new RootStoriteInsertAuth(option);
	}
}
