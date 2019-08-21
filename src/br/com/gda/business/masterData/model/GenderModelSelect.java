package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.business.masterData.model.decisionTree.RootGenderSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class GenderModelSelect extends ModelTemplate<GenderInfo> {

	public GenderModelSelect(GenderInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<GenderInfo> getDecisionTreeHook(DeciTreeOption<GenderInfo> option) {
		return new RootGenderSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
