package br.com.mind5.business.owner.model;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.decisionTree.OwnerRootDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnerModelDelete extends ModelTemplate<OwnerInfo> {

	public OwnerModelDelete(OwnerInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<OwnerInfo> getDecisionTreeHook(DeciTreeOption<OwnerInfo> option) {
		return new OwnerRootDelete(option);
	}
}
