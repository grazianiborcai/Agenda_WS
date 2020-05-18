package br.com.mind5.business.refundPolicyOwner.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.decisionTree.RootRefupownSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupownModelSearch extends ModelTemplate<RefupownInfo> {

	public RefupownModelSearch(String incomingData, HttpServletRequest request) {
		super(incomingData, request, RefupownInfo.class);
	}
	
	
	
	@Override protected DeciTree<RefupownInfo> getDecisionTreeHook(DeciTreeOption<RefupownInfo> option) {
		return new RootRefupownSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
