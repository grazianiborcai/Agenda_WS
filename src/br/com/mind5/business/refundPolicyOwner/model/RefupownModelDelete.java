package br.com.mind5.business.refundPolicyOwner.model;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.decisionTree.RootRefupownDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupownModelDelete extends ModelTemplate<RefupownInfo> {

	public RefupownModelDelete(RefupownInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<RefupownInfo> getDecisionTreeHook(DeciTreeOption<RefupownInfo> option) {
		return new RootRefupownDelete(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
