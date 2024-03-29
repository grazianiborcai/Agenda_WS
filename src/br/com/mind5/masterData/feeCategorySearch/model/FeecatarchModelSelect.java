package br.com.mind5.masterData.feeCategorySearch.model;

import br.com.mind5.masterData.feeCategorySearch.info.FeecatarchInfo;
import br.com.mind5.masterData.feeCategorySearch.model.decisionTree.FeecatarchRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FeecatarchModelSelect extends ModelTemplate<FeecatarchInfo> {

	public FeecatarchModelSelect(FeecatarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<FeecatarchInfo> getDecisionTreeHook(DeciTreeOption<FeecatarchInfo> option) {
		return new FeecatarchRootSelect(option);
	}
}
