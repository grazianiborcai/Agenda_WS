package br.com.mind5.masterData.refundPolicyGroup.model;

import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.model.decisionTree.RefugroupRootSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugroupModelSearch extends ModelTemplate<RefugroupInfo> {

	public RefugroupModelSearch(RefugroupInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<RefugroupInfo> getDecisionTreeHook(DeciTreeOption<RefugroupInfo> option) {
		return new RefugroupRootSearch(option);
	}
}
