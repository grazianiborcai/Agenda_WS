package br.com.mind5.business.refundPolicyStore.model;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.decisionTree.RefuporeRootDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporeModelDelete extends ModelTemplate<RefuporeInfo> {

	public RefuporeModelDelete(RefuporeInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<RefuporeInfo> getDecisionTreeHook(DeciTreeOption<RefuporeInfo> option) {
		return new RefuporeRootDelete(option);
	}
}
