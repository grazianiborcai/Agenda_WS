package br.com.mind5.business.refundPolicyStore.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.decisionTree.RefuporeRootSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporeModelSearch extends ModelTemplate<RefuporeInfo> {

	public RefuporeModelSearch(String incomingData, HttpServletRequest request) {
		super(incomingData, request, RefuporeInfo.class);
	}
	
	
	
	@Override protected DeciTree<RefuporeInfo> getDecisionTreeHook(DeciTreeOption<RefuporeInfo> option) {
		return new RefuporeRootSearch(option);
	}
}
