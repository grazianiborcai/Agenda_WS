package br.com.mind5.masterData.materialTypeSearch.model;

import br.com.mind5.masterData.materialTypeSearch.info.MatyparchInfo;
import br.com.mind5.masterData.materialTypeSearch.model.decisionTree.RootMatyparchSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatyparchModelSelect extends ModelTemplate<MatyparchInfo> {

	public MatyparchModelSelect(MatyparchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatyparchInfo> getDecisionTreeHook(DeciTreeOption<MatyparchInfo> option) {
		return new RootMatyparchSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
