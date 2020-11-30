package br.com.mind5.business.refundPolicyStore.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.decisionTree.RootRefuporeUpsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporeModelUpsert extends ModelTemplate<RefuporeInfo> {

	public RefuporeModelUpsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, RefuporeInfo.class);
	}
	
	
	
	@Override protected DeciTree<RefuporeInfo> getDecisionTreeHook(DeciTreeOption<RefuporeInfo> option) {
		return new RootRefuporeUpsert(option);
	}
}
