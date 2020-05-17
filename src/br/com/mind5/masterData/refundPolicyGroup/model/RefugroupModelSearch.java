package br.com.mind5.masterData.refundPolicyGroup.model;

import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.model.decisionTree.RootRefugroupSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugroupModelSearch extends ModelTemplate<RefugroupInfo> {

	public RefugroupModelSearch(RefugroupInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<RefugroupInfo> getDecisionTreeHook(DeciTreeOption<RefugroupInfo> option) {
		return new RootRefugroupSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
