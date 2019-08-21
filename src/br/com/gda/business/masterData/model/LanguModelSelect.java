package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.business.masterData.model.decisionTree.RootLanguSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
