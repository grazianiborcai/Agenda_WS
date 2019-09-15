package br.com.gda.business.owner.model;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.decisionTree.RootOwnerSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
