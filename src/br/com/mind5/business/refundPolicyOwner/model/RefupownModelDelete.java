package br.com.mind5.business.refundPolicyOwner.model;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.decisionTree.RefupownRootDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupownModelDelete extends ModelTemplate<RefupownInfo> {

	public RefupownModelDelete(RefupownInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<RefupownInfo> getDecisionTreeHook(DeciTreeOption<RefupownInfo> option) {
		return new RefupownRootDelete(option);
	}
}
