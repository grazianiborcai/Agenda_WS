package br.com.mind5.masterData.materialCategorySearch.model;

import br.com.mind5.masterData.materialCategorySearch.info.MategarchInfo;
import br.com.mind5.masterData.materialCategorySearch.model.decisionTree.MategarchRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MategarchModelSelect extends ModelTemplate<MategarchInfo> {

	public MategarchModelSelect(MategarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MategarchInfo> getDecisionTreeHook(DeciTreeOption<MategarchInfo> option) {
		return new MategarchRootSelect(option);
	}
}
