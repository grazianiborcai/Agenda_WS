package br.com.mind5.business.refundPolicyOwner.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.decisionTree.RootRefupownUpsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupownModelUpsert extends ModelTemplate<RefupownInfo> {

	public RefupownModelUpsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, RefupownInfo.class);
	}
	
	
	
	@Override protected DeciTree<RefupownInfo> getDecisionTreeHook(DeciTreeOption<RefupownInfo> option) {
		return new RootRefupownUpsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
