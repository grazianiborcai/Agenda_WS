package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootGenderSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
