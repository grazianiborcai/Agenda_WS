package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.LanguInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootLanguSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LanguModelSelect extends ModelTemplate<LanguInfo> {

	public LanguModelSelect(LanguInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<LanguInfo> getDecisionTreeHook(DeciTreeOption<LanguInfo> option) {
		return new RootLanguSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
