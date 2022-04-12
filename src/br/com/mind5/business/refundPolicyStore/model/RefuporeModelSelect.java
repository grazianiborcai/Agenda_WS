package br.com.mind5.business.refundPolicyStore.model;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.decisionTree.RefuporeRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporeModelSelect extends ModelTemplate<RefuporeInfo> {

	public RefuporeModelSelect(RefuporeInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<RefuporeInfo> getDecisionTreeHook(DeciTreeOption<RefuporeInfo> option) {
		return new RefuporeRootSelect(option);
	}
}
