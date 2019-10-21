package br.com.mind5.business.owner.model;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.decisionTree.RootOwnerSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnerModelSelect extends ModelTemplate<OwnerInfo> {

	public OwnerModelSelect(OwnerInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<OwnerInfo> getDecisionTreeHook(DeciTreeOption<OwnerInfo> option) {
		return new RootOwnerSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
